package school.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class SchoolNotFoundException extends AbstractThrowableProblem {
    public SchoolNotFoundException(Long id) {
        super(URI.create("/api/schools/NOT_FOUND"),
                "Not found",
                Status.NOT_FOUND,
                String.format("School not found with id: %d",id));
    }
}
