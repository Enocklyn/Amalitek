package Amalitek.amalitek.RestController;


import Amalitek.amalitek.Order.Order;
import Amalitek.amalitek.Order.OrderResponse;
import Amalitek.amalitek.Order.OrderService;
import Amalitek.amalitek.Product.ProductService;
import Amalitek.amalitek.ProductLine.ProductLineService;
import Amalitek.amalitek.User.UserService;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
public class APICOntroller {
 private ProductLineService PLS;
 private ProductService PS;
 private OrderService OS;
 private UserService US;
    @Value("classPath:OrderQLS.graghqls")
 private Resource schemaResource;

private GraphQL graphQL;

    public void loadSchema() throws IOException {

        File schemaFile =schemaResource.getFile();
        graphql.schema.idl.TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
           RuntimeWiring wiring = buildWiring();
           GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
           graphQL=GraphQL.newGraphQL(schema).build();
    }



    @PostMapping("/CreateOrder")
    public ResponseEntity<OrderResponse>CreateOrder
            (Principal p,@RequestBody Order order){
         try{

             return ResponseEntity.ok(OS.saveOrder(order));
         }catch (Exception ex){
         return ResponseEntity.ok(null);

         }
    }

    private RuntimeWiring buildWiring() {
        DataFetcher <List<OrderResponse>>fetcher1=data ->{
       return OS.findAllOrders();
       };
     DataFetcher <List<OrderResponse>> fetcher2=data ->{
     return OS.FindOrderByUser(data.getArgument("userName"));
     };
     return  RuntimeWiring.newRuntimeWiring().type("Query",typeWriting->typeWriting.dataFetcher("getAllOrder", fetcher1).dataFetcher("findOrder", fetcher2)).build();
    }
}
