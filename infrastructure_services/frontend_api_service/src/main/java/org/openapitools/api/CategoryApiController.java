package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T10:22:12.049448+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.hskaWebshop.base-path:/anon767/HsKA/1.0.0}")
public class CategoryApiController implements CategoryApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoryApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
