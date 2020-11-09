package Model;

public class Boat {

    private BoatType type;
    private BoatLength Size;

    public enum BoatType {
        SailBoat,
        MotorBoat,
        Kayak,
        Other
    }
    public Boat(BoatType type, BoatLength size) {


        this.type = type;
        this.Size = size;

    }

    public double valueConverter(){

        if(Size.getValueType() == BoatLength.ValueType.Meter){
            return Size.getValue()*3.2808;
        }
        else{
            return Size.getValue()/3.2808;
        }
    }

    public BoatType getBoatType() {
        return type;
    }

    public BoatLength getBoatSize() {
        return Size;
    }


    public void setBoatType(BoatType type) {
        this.type = type;
    }

    public void setBoatSize(BoatLength size) {
        this.Size = size;
    }
}

