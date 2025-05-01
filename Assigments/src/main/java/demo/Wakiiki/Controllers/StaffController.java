package demo.Wakiiki.Controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staff/")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // 1. get All staff
    @GetMapping("All")
    public Collection<Staff> getStaff (){
        return staffService.getAllStaff();
    }

    // 2. get specific staff id
    @GetMapping("{id}")
    public Staff getStaff_id(@PathVariable Long id){
        return staffService.getStaff(id);
    }

    // 3. insert / create / post
    @PostMapping("All")
    public ResponseEntity<Staff> Add_New_Staff(@RequestBody Staff newStaff){
        HttpHeaders header = new HttpHeaders();
        header.add("Posting","We are Saved your information");

        Staff staffBody = staffService.SaveStaff(newStaff);
        return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(staffBody);
    }

    // 4. update the staff information
    @PutMapping("{id}")
    public Staff Update_Staff(@PathVariable Long id, @RequestBody Staff newStaff){
        return staffService.Update_staff(id,newStaff);
    }

    // 5. delete the staff information
    @DeleteMapping("{id}")
    public Staff Deleting_Staff(@PathVariable Long id){
        return staffService.DeleteStaff(id);
    }
}

