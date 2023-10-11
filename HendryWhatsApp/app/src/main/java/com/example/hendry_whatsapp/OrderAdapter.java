package com.example.hendry_whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<YourOrderDetailModel> orders;
    private Context context;

    public OrderAdapter(Context context) {
        this.context = context;
    }

    public void setOrders(List<YourOrderDetailModel> orders) {
        this.orders = orders;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        YourOrderDetailModel order = orders.get(position);

        // Set data to the views in item_order.xml
        holder.textOrderStatus.setText("Order Status: " + order.getOrder_status());
        holder.textOrderDate.setText("Order Date: " + order.getOrder_date());
        holder.textCustomerName.setText("Customer Name: " + order.getFull_name());
        holder.textAddress.setText("Address: " + order.getAddress());

        // Set product details
        holder.textProductName.setText("Product: " + order.getProduct_name());
        holder.textQuantityAndTotal.setText("Quantity: " + order.getQuantity() + " | Total: $" + order.getGrand_total());
    }

    @Override
    public int getItemCount() {
        return orders != null ? orders.size() : 0;
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView textOrderStatus, textOrderDate, textCustomerName, textAddress;
        TextView textProductName, textQuantityAndTotal;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            textOrderStatus = itemView.findViewById(R.id.textOrderStatus);
            textOrderDate = itemView.findViewById(R.id.textOrderDate);
            textCustomerName = itemView.findViewById(R.id.textCustomerName);
            textAddress = itemView.findViewById(R.id.textAddress);
            textProductName = itemView.findViewById(R.id.textProductName);
            textQuantityAndTotal = itemView.findViewById(R.id.textQuantityAndTotal);
        }
    }
}
