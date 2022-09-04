import com.cpb.TencentCloudApi.DnspodClient;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.dnspod.v20210323.models.DescribeRecordListRequest;
import com.tencentcloudapi.dnspod.v20210323.models.DescribeRecordListResponse;
import com.tencentcloudapi.dnspod.v20210323.models.RecordListItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReqTest {

    //TODO
    private Credential credential = new Credential("AKIDhDTTBdXCaiZ9SUFkyvc2B3ez4sOeeMny", "wbz6wVnnX1EAqGPGsEJ7dttc6MPBgurX");
    private DnspodClient dnsPodClient = new DnspodClient(credential, "ap-guangzhou");

    @Test
    public void testDescribeRecordResponse() {
        DescribeRecordListRequest req = new DescribeRecordListRequest();
        req.setDomain("usstcrush.icu");
        try {
            DescribeRecordListResponse resp = dnsPodClient.DescribeRecordList(req);
            log.info("RequestId:" + resp.getRequestId());
            RecordListItem[] recordList = resp.getRecordList();
            List<String> recordListItems = new ArrayList<>();
            for (RecordListItem recordListItem : recordList) {
                recordListItems.add(recordListItem.getValue() + "::" + recordListItem.getName());
            }
            log.info("RecordList:" + recordListItems);
        } catch (TencentCloudSDKException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
