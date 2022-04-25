public class Phone {
    private int phoneNumber;
    private  String numberType;

    public Phone(int phoneNumber, String numberType) {
        this.phoneNumber = phoneNumber;
        this.numberType = numberType;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append("phoneNumber=").append(phoneNumber);
        sb.append(", numberType='").append(numberType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
