package school.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class StudentNotFoundException extends AbstractThrowableProblem {
    public StudentNotFoundException(Long id) {
        super(URI.create("/api/schools/NOT_FOUND"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Student not found with id: %d",id));
    }
}
