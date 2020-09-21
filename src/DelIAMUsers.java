import com.huawei.openstack4j.api.OSClient;
import com.huawei.openstack4j.api.OSClient.OSClientAKSK;
import com.huawei.openstack4j.model.common.ActionResponse;
import com.huawei.openstack4j.model.common.Identifier;
import com.huawei.openstack4j.model.identity.v3.User;
import com.huawei.openstack4j.openstack.OSFactory;
import com.huawei.openstack4j.openstack.iam.domain.credentialResource.CreatePermanentCredentialReq;
import com.huawei.openstack4j.openstack.iam.domain.credentialResource.PermanentCredentialResp;
import com.huawei.openstack4j.openstack.identity.v3.domain.KeystoneUser;

import java.util.List;

public class DelIAMUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String user = "xxx"; //用户名
        String password = "******"; //用户密码
        String userDomainId = "xxxxxxxxxxxx"; //用户id
        String authUrl = "https://iam.cn-north-1.myhuaweicloud.com/v3";//endpointUrl

        OSClient.OSClientV3 osclient = OSFactory.builderV3()
                .endpoint(authUrl)
                .credentials(user, password, Identifier.byId(userDomainId))
                .scopeToDomain(Identifier.byId(userDomainId))
                .authenticate();

        //增加用户
//        User createSampleUser01 = KeystoneUser.builder().name("wu1234567").build();
//        User createUser01 = osclient.identity().users().create(createSampleUser01);
//        System.out.println(createUser01);

        //删除用户
        String delUserID = "09ea37532a0026d11f6bc0082aac246e";
        ActionResponse response = osclient.identity().users().delete(delUserID);
        System.out.println(response);

	}

}
