package TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Code;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class MailUtils {

	char otp;
   
  
    public   String  testEmailSubject(String site) throws IOException, MailosaurException {
    String apiKey = "OZzkvWFGkGxsVCifJjKkqXNefeJucN6D";
    String serverId = "vvaxddnq";
    String serverDomain = site;

    MailosaurClient mailosaur = new MailosaurClient(apiKey);

    MessageSearchParams params = new MessageSearchParams();
    params.withServer(serverId);

    SearchCriteria criteria = new SearchCriteria();
    criteria.withSentTo(serverDomain);

    Message message = mailosaur.messages().get(params, criteria);

      assertNotNull(message);
    System.out.println(message.subject());
   String expected= message.subject();
    assertEquals(expected, message.subject());
     message.html().body(); 


    System.out.println(message.html().codes().size());

    Code firstCode = message.html().codes().get(0);
    System.out.println(firstCode.value()); 
    String code=firstCode.value();
    System.out.println(code);
    
	return code;
    
    
  }
}
