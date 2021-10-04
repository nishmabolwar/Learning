public class gender extends Size{

    public gender(SearchName searchName) {
        super(searchName);
    }
    @Override
    public String generateName() {
        return "female"+super.generateName();
    }
}
