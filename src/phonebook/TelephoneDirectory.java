package phonebook;

import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    public List<Record> telephoneDirectory = new ArrayList<>();


    public void add(Record record) {
        telephoneDirectory.add(record);
    }

    public void add(String name, String phone) {
        telephoneDirectory.add(new Record(name, phone));
    }

    public Record find(String name) {
        if (name == null || name.isEmpty())
            return null;
        for (Record record : telephoneDirectory) {
            if (record.getName().equals(name)){
            return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        if (name == null || name.isEmpty())
            return new ArrayList<>();
        List<Record> result = new ArrayList<>();
        for (Record record : telephoneDirectory) {
            if (record.getName().equals(name)) {
                result.add(record);
            }
        }
        return result;
    }


}
