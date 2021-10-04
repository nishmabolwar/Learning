public abstract class NameDecorator implements SearchName{
    private SearchName searchName;

    public NameDecorator(SearchName searchName) {
        this.searchName=searchName;
    }

    @Override
    public String generateName() {
        return searchName.generateName();
    }
}
