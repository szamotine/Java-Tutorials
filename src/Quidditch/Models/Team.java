package Quidditch.Models;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    //#region Constructors
    public Team(String house, String keeper, String seeker, String[] chasers) {
        if(house == null || keeper == null ||seeker == null){
            throw new IllegalArgumentException("Fields cannot be null");
        }
        if( house.isBlank() || keeper.isBlank() || seeker.isBlank()){
            throw new IllegalArgumentException("Fields cannot be blank");
        }

        if( chasers == null || chasers.length != 3){
            throw new IllegalArgumentException("Chasers must have 3 members and cannot be null");
        }
        if(hasBlank(chasers) || hasNull(chasers)){
            throw new IllegalArgumentException("Chasers may not contain null or blank entries");
        }

        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team t){
        this.house = t.house;
        this.keeper = t.keeper;
        this.seeker  = t.seeker;
        this.chasers = Arrays.copyOf(t.chasers, t.chasers.length);
    }
    //#endregion

   //#region Getters
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public String[] getChasers() {
        return Arrays.copyOf(this.chasers, this.chasers.length);
    }

    public void setChasers(String[] chasers) {
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    @Override
    public String toString(){
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: "  + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public static String getPositionChaser(){
        return POSITION_CHASER;
    }
    public static String getPositionSeeker(){
        return POSITION_SEEKER;
    }
    public static String getPositionKeeper(){
        return POSITION_KEEPER;
    }
    //#endregion

    public static boolean hasNull(String[] array){
        return Arrays.stream(array).anyMatch(Objects::isNull);
    }
    public static boolean hasBlank(String[] array){
        return Arrays.stream(array).anyMatch(String::isBlank);
    }
    public void checkParam(String param){
        if(param == null || param.isBlank()){
            throw new IllegalArgumentException(param + " cannot be null or blank");
        }
    }
}
