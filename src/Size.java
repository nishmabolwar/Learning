public class Size extends NameDecorator {

    Size(SearchName searchName){
        super(searchName);
    }
    @Override
    public String generateName() {
        return "size"+super.generateName();
    }

}
