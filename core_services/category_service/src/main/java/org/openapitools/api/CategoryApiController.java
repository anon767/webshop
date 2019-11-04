package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T09:48:47.669952+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.hskaWebshop.base-path:}")
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
