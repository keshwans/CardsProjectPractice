package org.c4q.cardsprojectpractice.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.c4q.cardsprojectpractice.R;
import org.c4q.cardsprojectpractice.models.CardData;
import org.c4q.cardsprojectpractice.models.MusicData;
import org.c4q.cardsprojectpractice.models.WeatherData;
import org.c4q.cardsprojectpractice.ui.helpers.ItemTouchHelperAdapter;
import org.c4q.cardsprojectpractice.ui.helpers.ItemTouchHelperViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by keshwans on 6/27/15.
 */
public class FeedCardsAdapter extends RecyclerView.Adapter<FeedCardsAdapter.CardViewHolder>
        implements ItemTouchHelperAdapter {



    /**
     * Listener for manual initiation of a drag.
     */
    public interface OnStartDragListener {

        /**
         * Called when a view is requesting a start of a drag.
         *
         * @param viewHolder The holder of the view to drag.
         */
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }


    List<CardData> cardDataList;

    public FeedCardsAdapter() {
        cardDataList = new ArrayList<>();
    }

    public List<CardData> getCardDataList() {
        return cardDataList;
    }

    public void setCardDataList(List<CardData> cardDataList) {
        this.cardDataList = cardDataList;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case CardData.CARD_SEQ_HOSHIKO:
                View hoshikoCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hoshiko, parent, false);
                CardViewHolder hoshikoCardViewHolder = new CardViewHolder(hoshikoCard);
                return hoshikoCardViewHolder;

            case CardData.CARD_SEQ_LUKE:
                View lukeCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_luke, parent, false);
                CardViewHolder lukeCardViewHolder = new CardViewHolder(lukeCard);
                return lukeCardViewHolder;

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        return;
    }

    @Override
    public int getItemCount() {
        return cardDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        CardData cardData = cardDataList.get(position);
        return cardData.getStudentId();
    }


    @Override
    public void onItemDismiss(int position) {
        cardDataList.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(cardDataList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public CardViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class WeatherCardViewHolder extends CardViewHolder implements ItemTouchHelperViewHolder {
        CardView cvWeatherCard;
        TextView tvZipCode;
        TextView tvTemperature;

        public WeatherCardViewHolder(View itemView) {
            super(itemView);

            this.cvWeatherCard = (CardView) itemView.findViewById(R.id.weather_cardview);
            this.tvZipCode = (TextView) cvWeatherCard.findViewById(R.id.zip_code);
            this.tvTemperature = (TextView) cvWeatherCard.findViewById(R.id.temperature);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }


        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }

    public static class MusicCardViewHolder extends CardViewHolder implements ItemTouchHelperViewHolder {
        CardView cvMusicCard;
        TextView tvArtist;
        TextView tvTitle;

        public MusicCardViewHolder(View itemView) {
            super(itemView);

            this.cvMusicCard = (CardView) itemView.findViewById(R.id.music_cardview);
            this.tvArtist = (TextView) cvMusicCard.findViewById(R.id.artist);
            this.tvTitle = (TextView) cvMusicCard.findViewById(R.id.title);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }


        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }


    public static class HoshikoCardViewHolder extends CardViewHolder implements ItemTouchHelperViewHolder {
        CardView cvHoshikoCard;
        TextView studentName;
        TextView message;
        ImageView photo;

        public HoshikoCardViewHolder(View itemView) {
            super(itemView);

            this.cvHoshikoCard = (CardView) itemView.findViewById(R.id.hoshiko_cardview);
            this.studentName = (TextView) cvHoshikoCard.findViewById(R.id.student_name);
            this.message = (TextView) cvHoshikoCard.findViewById(R.id.message);
            this.photo = (ImageView) cvHoshikoCard.findViewById(R.id.photo);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }


        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }

}
