package Oving10.Oppg1;

import java.util.*;


public class ArrangementRegister {
    final private ArrayList<Arrangement> arrangementList;

    public ArrangementRegister() {
         arrangementList = new ArrayList<>();
    }

    public List<Arrangement> getList() {
        return arrangementList;
    }

    public void newArrangement(Arrangement input) {
        arrangementList.add(input);
    }

    public List<Arrangement> arangementsLocationList(String location) {
        return arrangementList.stream()
                .filter(a -> a.getLocation().equals(location))
                .toList();
    }

    /**
     * @param date Integer representing a date (YYYY-MM-DD). Start of interval.
     * @return List of {@code Arrangements} with same date {@code date}.
     */
    public List<Arrangement> arangementsDateList(int date) {
        return arrangementList.stream()
                .filter(a -> a.getDate() == date)
                .toList();
    }

    public ArrayList<Type> getValidTypes() {
        return new ArrayList<>(Arrays.asList(Type.values()));
    }


    /**
     * @param startDate Integer representing a date (YYYY-MM-DD). Start of interval.
     * @param endDate Integer representing a date (YYYY-MM-DD). End of interval.
     * @return List of {@code Arrangement} sorted after time (HH:MM).
     */
    public List<Arrangement> arangementsTimeList(int startDate, int endDate) {
        if (startDate > endDate) {
            throw new IllegalArgumentException("Cannot have start bigger than end.");
        }

        final long startTime = startDate * 10000L;
        final long endTime = (endDate * 10000L) + 2359;

        List<Arrangement> intervalList = new ArrayList<>(arrangementList.stream()
                .filter(a -> {
                    System.out.println(a.getTime()>=startTime);
                    System.out.println(a.getTime()<=endTime);
                    return a.getTime() >= startTime && a.getTime() <= endTime;
                })
                .toList());

        intervalList.sort(Comparator.comparing(Arrangement::getTime));

        return intervalList;
    }

    public List<Arrangement> sortLocationTypeDate(List<Arrangement> list) {
        list.sort(Comparator.comparing(Arrangement::getLocation)
                .thenComparing(Arrangement::getType)
                .thenComparing(Arrangement::getTime));

        return list;
    }
}
