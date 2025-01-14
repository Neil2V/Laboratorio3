package tienda.controllers.impl;

import tienda.Lab3_Pregunta3.ClienteFlyweight;
import tienda.config.Paths;
//import tienda.config.Paths;
import tienda.controllers.CustomerController;
import tienda.models.Cliente;
import tienda.repositories.ClienteRepositorio;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
import java.util.LinkedList;
import java.util.List;
//import org.bson.types.ObjectId;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import tienda.InterfazCliente.GUI_Cliente;

public class CustomerControllerImpl implements CustomerController {
    
    private static final String ID = "id";

    private ClienteRepositorio customerRepository;

    public CustomerControllerImpl(ClienteRepositorio custRepository) {
        this.customerRepository = custRepository;
    }

    @Override
    public void  create(Context context) {
                   
    Cliente customer = context.bodyAsClass(Cliente.class);
      customerRepository.create(customer);
        
        context.status(HttpStatus.CREATED_201)
               .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(customer.getId()));

                                            }

    @Override
    public void delete(Context context) {
        customerRepository.delete(context.pathParam(ID));
                            }

    @Override
    public void find(Context context) {
        String id = context.pathParam(ID);
        Cliente customer = customerRepository.find(id);

        if (customer == null) {
            throw new NotFoundResponse(String.format("A customer with id '%s' is not found", id));
        }
        context.json(customer);
                                    }

    @Override
    public void findAll(Context context) {
        context.json(customerRepository.findAll());
    }

    @Override
    public void update(Context context) {
        ClienteFlyweight customer = context.bodyAsClass(ClienteFlyweight.class);
        String id = context.pathParam(ID);

        if (customer.getId() != null && !customer.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }
        customerRepository.update(customer, id);

                                         }

}