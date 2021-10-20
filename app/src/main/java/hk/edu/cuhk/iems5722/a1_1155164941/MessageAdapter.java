package hk.edu.cuhk.iems5722.a1_1155164941;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends ArrayAdapter {

    public MessageAdapter(@NonNull Context context, @NonNull ArrayList<Message> messages) {
        super(context, 0,messages);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Message msg=(Message) getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.lv_msg_item,parent,false);
        }
        TextView tvMessage=(TextView) convertView.findViewById(R.id.item_message);
        TextView tvTime=(TextView) convertView.findViewById(R.id.item_time);
        tvMessage.setText(msg.getMessage());
        tvTime.setText(msg.getTime());
        return convertView;
    }
}
