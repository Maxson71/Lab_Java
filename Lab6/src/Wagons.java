class Wagons {
    private String type; // тип вагону
    private Integer passengers; // кількість пасажирів
    private Integer baggage; // кількість багажу в тоннах
    private String comfort; // рейтиг комфорту вагону
    private Integer amount; // кількість вагонів


    public Wagons(String type, Integer passengers, Integer baggage, String comfort, Integer amount) {
        this.type = type;
        this.passengers = passengers;
        this.baggage = baggage;
        this.comfort = comfort;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }
    public Integer getPassengers() {
        return passengers;
    }
    public Integer getBaggage() {
        return baggage;
    }
    public String getComfort() {
        return comfort;
    }
    public Integer getAmount() {
        return amount;
    }

    // підклас Пасажирський вагон
    public static class PassengerWagons extends Wagons{
        public PassengerWagons(String type, int passengers, String comfort, int amount) {
            super(type, passengers,null, comfort, amount);
        }
    }

    // підклас Вантажний вагон
    public static class FreightWagons extends Wagons{
        public FreightWagons(String type, int baggage, int amount) {
            super(type, null , baggage, null, amount);
        }
    }
}

