package org.c4q.cardsprojectpractice.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.c4q.cardsprojectpractice.R;
import org.c4q.cardsprojectpractice.models.CardData;
import org.c4q.cardsprojectpractice.models.MusicData;
import org.c4q.cardsprojectpractice.models.WeatherData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keshwans on 6/27/15.
 */
public class FeedCardsAdapter extends RecyclerView.Adapter<FeedCardsAdapter.CardViewHolder> {

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

            case 1:
                View weatherCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_card, parent, false);
                WeatherCardViewHolder weatherCardViewHolder = new WeatherCardViewHolder(weatherCard);
                return weatherCardViewHolder;

            case 2:
                View musicCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_card, parent, false);
                MusicCardViewHolder musicCardViewHolder = new MusicCardViewHolder(musicCard);
                return musicCardViewHolder;

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        CardData cardData = cardDataList.get(position);
        if (cardData instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) cardData;
            WeatherCardViewHolder weatherCardViewHolder = (WeatherCardViewHolder) holder;

            weatherCardViewHolder.tvTemperature.setText(weatherData.getTemperature());
            weatherCardViewHolder.tvZipCode.setText(weatherData.getZip());

        } else if (cardData instanceof MusicData) {
            MusicData musicData = (MusicData) cardData;
            MusicCardViewHolder musicCardViewHolder = (MusicCardViewHolder) holder;

            musicCardViewHolder.tvArtist.setText(musicData.getArtist());
            musicCardViewHolder.tvTitle.setText(musicData.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return cardDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        CardData cardData = cardDataList.get(position);
        if (cardData instanceof WeatherData) {
            return 1;
        }
        if (cardData instanceof MusicData) {
            return 2;
        }
        return -1;
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public CardViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class WeatherCardViewHolder extends CardViewHolder {
        CardView cvWeatherCard;
        TextView tvZipCode;
        TextView tvTemperature;

        public WeatherCardViewHolder(View itemView) {
            super(itemView);

            this.cvWeatherCard = (CardView) itemView.findViewById(R.id.weather_cardview);
            this.tvZipCode = (TextView) cvWeatherCard.findViewById(R.id.zip_code);
            this.tvTemperature = (TextView) cvWeatherCard.findViewById(R.id.temperature);
        }
    }

    public static class MusicCardViewHolder extends CardViewHolder {
        CardView cvMusicCard;
        TextView tvArtist;
        TextView tvTitle;

        public MusicCardViewHolder(View itemView) {
            super(itemView);

            this.cvMusicCard = (CardView) itemView.findViewById(R.id.music_cardview);
            this.tvArtist = (TextView) cvMusicCard.findViewById(R.id.artist);
            this.tvTitle = (TextView) cvMusicCard.findViewById(R.id.title);
        }
    }
}
