public class StackElement {
    private int data;
    private boolean isValid;

    public StackElement(int data, boolean isValid) {
        this.data = data;
        this.isValid = isValid;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "{" + "data:" + data + ", isValid:" + String.valueOf(isValid) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackElement element = (StackElement) o;
        return data == element.data &&
                isValid == element.isValid;
    }
}