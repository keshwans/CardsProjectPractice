package org.c4q.cardsprojectpractice.models;

import org.c4q.cardsprojectpractice.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keshwans on 6/27/15.
 */
public class TestData {

    public static List<CardData> getTestData() {
        List<CardData> cardDataList = new ArrayList<>();

        CardData hoshiko = new CardData(CardData.CARD_SEQ_HOSHIKO );
        CardData luke = new CardData(CardData.CARD_SEQ_LUKE);

        cardDataList.add(hoshiko);
        cardDataList.add(luke);
//
//        WeatherData weatherData = new WeatherData("10044", "82");
//        cardDataList.add(weatherData);
//
//        MusicData musicData = new MusicData("Allison", "Amazing Grace");
//        cardDataList.add(musicData);

        return cardDataList;
    }
}
