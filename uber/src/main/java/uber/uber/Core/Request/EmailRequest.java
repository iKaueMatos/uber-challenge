package uber.uber.Core.Request;

import lombok.Data;

@Data
public class EmailRequest {
    private String to;
    private String body;
    private String subject;
}
