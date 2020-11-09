package Model;

public class BoatLength {


        private ValueType Value_Type;
        private double Value;

        public enum ValueType {
            Meter,
            Feet
        }

        public BoatLength(double Value, ValueType Value_Type) {

            this.Value_Type = Value_Type;
            this.Value = Value;

        }

        public ValueType getValueType() {
            return Value_Type;
        }

        public double getValue() {
            return Value;
        }


        public void setValueType(ValueType type) {
            this.Value_Type = Value_Type;
        }

        public void setValue(double Value) {
            this.Value = Value;
        }
    }
