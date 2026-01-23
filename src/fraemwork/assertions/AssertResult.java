package fraemwork.assertions;

public abstract class AssertResult {
    private final boolean success;
    public AssertResult (boolean sucsess){
        this.success = sucsess;
    }
    public boolean isSuccess(){
        return success;
    }

    public abstract String toString();
}
