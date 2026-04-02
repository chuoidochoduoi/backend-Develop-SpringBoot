package org.example.springboottest.s3.Repositories;


import org.example.springboottest.s3.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    public List<Enrollment> enrollments = new ArrayList<>(List.of(
            new Enrollment(1, "Phạm Đức Cường", 101),
            new Enrollment(2, "Phạm Đức Cường", 102),
            new Enrollment(3, "Nguyễn Hoàng Nam", 101),
            new Enrollment(4, "Trần Thu Hà", 103),
            new Enrollment(5, "Lê Minh Tuấn", 105),
            new Enrollment(6, "Phạm Đức Cường", 105)
    ));



}
