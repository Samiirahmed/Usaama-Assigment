package demo.Wakiiki.Controllers;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    private Map<Long, Staff> staffs = new ConcurrentHashMap<>();
    private AtomicLong Autoid = new AtomicLong();

    // reading or selecting all staff information
    public Collection<Staff> getAllStaff (){return staffs.values();}
    // reading in specific id or information
    public Staff getStaff(@PathVariable Long id){
        return staffs.get(id);
    }
    // creating / saving
    public Staff SaveStaff (Staff newStaff){
        Long staff_id = newStaff.getId() != null ? newStaff.getId() : Autoid.incrementAndGet();
        newStaff.setId(staff_id);
        staffs.put(staff_id,newStaff);
        return newStaff;
    }

    // delete with specific id
    public Staff DeleteStaff (@PathVariable Long id){
        return staffs.remove(id);
    }

    // update staff information
    public Staff Update_staff (Long id, Staff newStaff){
        if (staffs.containsKey(id)){
            Staff oldStaff = new Staff();
            oldStaff.setName(newStaff.getName());
            oldStaff.setRole(newStaff.getRole());

            staffs.put(id,oldStaff);

            return oldStaff;
        }else
            return null;
    }
}

