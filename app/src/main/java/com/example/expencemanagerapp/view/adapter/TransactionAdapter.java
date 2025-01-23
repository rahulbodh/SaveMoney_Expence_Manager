package com.example.expencemanagerapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expencemanagerapp.R;
import com.example.expencemanagerapp.model.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_GET = Transaction.TYPE_GET;
    private static final int TYPE_PAY = Transaction.TYPE_PAY;

    private Context context;
    private List<Transaction> transactionList;

    public TransactionAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
    }

    @Override
    public int getItemViewType(int position) {
        return transactionList.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        if (viewType == TYPE_GET) {
            View view = inflater.inflate(R.layout.transaction_get_item, parent, false);
            return new GetViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.transaction_pay_item, parent, false);
            return new PayViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);

        if (holder instanceof GetViewHolder) {
            ((GetViewHolder) holder).recentActivityTextView.setText(transaction.getRecentActivity());
            ((GetViewHolder) holder).getMoneyTextView.setText(transaction.getGetMoney());
        } else if (holder instanceof PayViewHolder) {
            ((PayViewHolder) holder).recentActivityTextView.setText(transaction.getRecentActivity());
            ((PayViewHolder) holder).paidMoneyTextView.setText(transaction.getPaidMoney());
        }
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    // ViewHolder for "Get Money" transactions
    public static class GetViewHolder extends RecyclerView.ViewHolder {
        TextView recentActivityTextView;
        TextView getMoneyTextView;

        public GetViewHolder(@NonNull View itemView) {
            super(itemView);
            recentActivityTextView = itemView.findViewById(R.id.getActivityTextView);
            getMoneyTextView = itemView.findViewById(R.id.getTextView);
        }
    }

    // ViewHolder for "Pay Money" transactions
    public static class PayViewHolder extends RecyclerView.ViewHolder {
        TextView recentActivityTextView;
        TextView paidMoneyTextView;

        public PayViewHolder(@NonNull View itemView) {
            super(itemView);
            recentActivityTextView = itemView.findViewById(R.id.paidActivityTextView);
            paidMoneyTextView = itemView.findViewById(R.id.paidTextView);
        }
    }
}