import com.cpb.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class GetIpTest {

    @Test
    public void getIpAddress() {
        String logLevel = "INFO";
        Long start = System.currentTimeMillis();
        log.info(Utils.getIpAddress(logLevel));
        log.info("花费：" + (System.currentTimeMillis() - start) + "ms");
    }
}
