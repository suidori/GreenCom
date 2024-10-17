package attendance.management.attendance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceResponsePageDto {

    @JsonIgnore
    private List<Attendance> content;

    private List<AttendanceResponseDto> list;
    private int totalElements;
    private int totalPages;
    private int size;
}
