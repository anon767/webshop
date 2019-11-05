package org.openapitools.api;

import com.hska.webshop.category.Repository.CategoryRepository;
import io.swagger.annotations.ApiParam;
import org.openapitools.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-04T09:48:47.669952+01:00[Europe/Berlin]")

@Controller
@RequestMapping("${openapi.hskaWebshop.base-path:}")
public class CategoryApiController implements CategoryApi {
    private final static Logger LOGGER = Logger.getLogger(CategoryApiController.class.getSimpleName());
    private final NativeWebRequest request;

    @Autowired
    public CategoryApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Autowired
    private CategoryRepository repository;


    @Override
    public ResponseEntity<Void> addCategory(@ApiParam(value = "category item to add") @Valid @RequestBody Category category) {
        LOGGER.log(LOGGER.getLevel().INFO, category.toString());
        if (!validate(category)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        category = repository.save(category);

        if (category.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private boolean validate(Category category) {
        return category.getId() != null;
    }

    @Override
    public ResponseEntity<Void> deleteCategory(@NotNull @ApiParam(value = "the category id", required = true) @Valid @RequestParam(value = "id", required = true) Integer id) {
        if (repository.findOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>((List<Category>) repository.findAll(), HttpStatus.OK);
    }
}
