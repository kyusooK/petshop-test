package petshop.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//<<< Resilency / Circuit Breaker
@FeignClient(
    name = "pet-data-management",
    url = "${api.url.pet-data-management}"
)
public interface PetProfileService {
    @RequestMapping(method = RequestMethod.GET, path = "/petProfiles/{id}")
    public PetProfile getPetProfile(@PathVariable("id") Long id);
}
//>>> Resilency / Circuit Breaker
