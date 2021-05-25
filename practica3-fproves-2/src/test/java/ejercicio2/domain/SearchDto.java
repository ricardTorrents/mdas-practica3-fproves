package ejercicio2.domain;

public class SearchDto {
    private final String fromAirport;
    private final String toAirport;
    private final String dateGo;
    private final String dateReturn;


    public SearchDto(String from,
                         String to,
                         String outboundDate,
                         String returnDate
    ) {
        this.fromAirport = from;
        this.toAirport = to;
        this.dateGo = outboundDate;
        this.dateReturn = returnDate;

    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public String getDateGo() {
        return dateGo;
    }

    public String getDateReturn() {
        return dateReturn;
    }



}
