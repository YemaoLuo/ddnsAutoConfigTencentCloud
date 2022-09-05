import com.cpb.utils.Utils;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.dnspod.v20210323.DnspodClient;
import com.tencentcloudapi.dnspod.v20210323.models.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReqTest {

    private Credential credential = new Credential("SECRET_ID", "SECRET_KEY");
    private DnspodClient dnsPodClient = new DnspodClient(credential, "ap-guangzhou");


    @Test
    public void testSplit() {
        String a = "www;@;student";
        String[] subDomains = a.split(";");
        for (String s : subDomains) {
            log.info(s);
        }
    }

    @Test
    public void testDescribeRecordResponse() {
        DescribeRecordListRequest req = new DescribeRecordListRequest();
        req.setDomain("usstcrush.icu");
        try {
            DescribeRecordListResponse resp = dnsPodClient.DescribeRecordList(req);
            log.info("RequestId:" + resp.getRequestId());
            RecordListItem[] recordList = resp.getRecordList();
            List<String> recordListItems = new ArrayList<>();
            List<Long> recordListID = new ArrayList<>();
            for (RecordListItem recordListItem : recordList) {
                recordListItems.add(recordListItem.getRecordId() + "::" + recordListItem.getValue() + "::" + recordListItem.getName());
                recordListID.add(recordListItem.getRecordId());
            }
            log.info("RecordList:" + recordListItems);
            //前两个记录是不需要删除的
            recordListID.remove(0);
            recordListID.remove(0);
            log.info("RecordIdList:" + recordListID);
        } catch (TencentCloudSDKException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDeleteRecord() {
        List<Long> deleteIdList = getRecordList();
        deleteIdList.forEach(x -> {
            try {
                DeleteRecordRequest req = new DeleteRecordRequest();
                req.setDomain("usstcrush.icu");
                req.setRecordId(x);
                DeleteRecordResponse resp = dnsPodClient.DeleteRecord(req);
                log.info("RequestId:" + resp.getRequestId());
            } catch (TencentCloudSDKException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        });
    }

    public List<Long> getRecordList() {
        DescribeRecordListRequest req = new DescribeRecordListRequest();
        req.setDomain("usstcrush.icu");
        try {
            DescribeRecordListResponse resp = dnsPodClient.DescribeRecordList(req);
            log.info("RequestId:" + resp.getRequestId());
            RecordListItem[] recordList = resp.getRecordList();
            List<Long> recordListID = new ArrayList<>();
            for (RecordListItem recordListItem : recordList) {
                recordListID.add(recordListItem.getRecordId());
            }
            //前两个记录是不需要删除的
            recordListID.remove(0);
            recordListID.remove(0);
            return recordListID;
        } catch (TencentCloudSDKException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateRecordResponse() {
        CreateRecordRequest req1 = new CreateRecordRequest();
        req1.setDomain("usstcrush.icu");
        req1.setRecordType("A");
        req1.setRecordLine("默认");
        req1.setValue(Utils.getIpAddress("INFO"));
        req1.setSubDomain("www");
        CreateRecordRequest req2 = new CreateRecordRequest();
        req2.setDomain("usstcrush.icu");
        req2.setRecordType("A");
        req2.setRecordLine("默认");
        req2.setValue(Utils.getIpAddress("INFO"));
        req2.setSubDomain("@");
        try {
            CreateRecordResponse resp1 = dnsPodClient.CreateRecord(req1);
            CreateRecordResponse resp2 = dnsPodClient.CreateRecord(req2);
            log.info(resp1.getRequestId());
            log.info(resp2.getRequestId());
            testDescribeRecordResponse();
        } catch (TencentCloudSDKException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
