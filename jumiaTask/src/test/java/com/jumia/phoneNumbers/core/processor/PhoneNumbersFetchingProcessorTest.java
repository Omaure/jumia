package com.jumia.phoneNumbers.core.processor;

import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingRequest;
import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingResponse;
import com.jumia.PhoneNumber.core.exception.CountryDoesNotExistException;
import com.jumia.PhoneNumber.core.models.Customer;
import com.jumia.PhoneNumber.core.processor.PhoneNumbersFetchingProcessor;
import com.jumia.PhoneNumber.core.repo.PhoneNumberRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumbersFetchingProcessorTest {

    private final PhoneNumberRepo phoneNumberRepo = Mockito.mock(PhoneNumberRepo.class);

    @Test
    void fetchingPhoneNumbersWithNonValidCountryThrowsException() {
        PhoneNumbersFetchingRequest request = new PhoneNumbersFetchingRequest("");

        PhoneNumbersFetchingProcessor processor = new PhoneNumbersFetchingProcessor(request, phoneNumberRepo);

        try {
            processor.execute();
        } catch (CountryDoesNotExistException e) {
            assertThat(e.getArguments().get("field")).isEqualTo("country");
        }
    }

    @Test
    void fetchingPhonesWithoutCountryWorks() {

        Customer firstCustomer = new Customer(1, "Test 1", "(237) 697151594");
        Customer secondCustomer = new Customer(2, "Test 2", "(258) 847651504");
        Customer thirdCustomer = new Customer(3, "Test 3", "(256) 775069443");
        Customer fourthCustomer = new Customer(4, "Test 2", "(237) 677046616");

        List<Customer> customers = List.of(firstCustomer, secondCustomer, thirdCustomer, fourthCustomer);

        Mockito.when(phoneNumberRepo.findAll()).thenReturn(customers);

        PhoneNumbersFetchingRequest request = new PhoneNumbersFetchingRequest();

        PhoneNumbersFetchingResponse response = new PhoneNumbersFetchingProcessor(request, phoneNumberRepo).execute();

        Assert.assertEquals(4, response.getCustomerPhonesList().size());

        Assert.assertEquals(firstCustomer.getPhone(), response.getCustomerPhonesList().get(0).getPhone());
        Assert.assertEquals(firstCustomer.getName(), response.getCustomerPhonesList().get(0).getName());
        Assert.assertEquals(firstCustomer.getId(), response.getCustomerPhonesList().get(0).getId());

        Assert.assertEquals(secondCustomer.getPhone(), response.getCustomerPhonesList().get(1).getPhone());
        Assert.assertEquals(secondCustomer.getName(), response.getCustomerPhonesList().get(1).getName());
        Assert.assertEquals(secondCustomer.getId(), response.getCustomerPhonesList().get(1).getId());

        Assert.assertEquals(thirdCustomer.getPhone(), response.getCustomerPhonesList().get(2).getPhone());
        Assert.assertEquals(thirdCustomer.getName(), response.getCustomerPhonesList().get(2).getName());
        Assert.assertEquals(thirdCustomer.getId(), response.getCustomerPhonesList().get(2).getId());

        Assert.assertEquals(fourthCustomer.getPhone(), response.getCustomerPhonesList().get(3).getPhone());
        Assert.assertEquals(fourthCustomer.getName(), response.getCustomerPhonesList().get(3).getName());
        Assert.assertEquals(fourthCustomer.getId(), response.getCustomerPhonesList().get(3).getId());
    }

    @Test
    void fetchingPhonesForCameroonWorks() {

        String cameroonRegex = "\\(237\\) ?[2368]\\d{7,8}$";

        Customer firstCustomer = new Customer(1, "Cameroon Test 1", "(237) 697151594");
        Customer secondCustomer = new Customer(2, "Test 2", "(258) 847651504");
        Customer thirdCustomer = new Customer(3, "Test 3", "(256) 775069443");
        Customer fourthCustomer = new Customer(4, "Cameroon Test 2", "(237) 677046616");

        List<Customer> customers = List.of(firstCustomer, secondCustomer, thirdCustomer, fourthCustomer);

        Mockito.when(phoneNumberRepo.findAll()).thenReturn(customers);

        PhoneNumbersFetchingRequest request = new PhoneNumbersFetchingRequest("Cameroon");

        PhoneNumbersFetchingResponse response = new PhoneNumbersFetchingProcessor(request, phoneNumberRepo).execute();

        int cameroonCustomersSize = (int) customers
                .stream()
                .filter(customer -> customer.getPhone().matches(cameroonRegex))
                .count();

        Assert.assertEquals(cameroonCustomersSize, response.getCustomerPhonesList().size());

        Assert.assertEquals(firstCustomer.getPhone(), response.getCustomerPhonesList().get(0).getPhone());
        Assert.assertEquals(firstCustomer.getName(), response.getCustomerPhonesList().get(0).getName());
        Assert.assertEquals(firstCustomer.getId(), response.getCustomerPhonesList().get(0).getId());

        Assert.assertEquals(fourthCustomer.getPhone(), response.getCustomerPhonesList().get(1).getPhone());
        Assert.assertEquals(fourthCustomer.getName(), response.getCustomerPhonesList().get(1).getName());
        Assert.assertEquals(fourthCustomer.getId(), response.getCustomerPhonesList().get(1).getId());
    }

    @Test
    void fetchingPhonesForEthiopiaWorks() {
        String ethiopiaRegex = "\\(251\\) ?[1-59]\\d{8}$";

        Customer firstCustomer = new Customer(1, "Ethiopia Test 1", "(251) 914701723");
        Customer secondCustomer = new Customer(2, "Test 2", "(258) 847651504");
        Customer thirdCustomer = new Customer(3, "Test 3", "(256) 775069443");
        Customer fourthCustomer = new Customer(4, "Ethiopia Test 2", "(251) 914701723");

        List<Customer> customers = List.of(firstCustomer, secondCustomer, thirdCustomer, fourthCustomer);

        Mockito.when(phoneNumberRepo.findAll()).thenReturn(customers);

        PhoneNumbersFetchingRequest request = new PhoneNumbersFetchingRequest("Ethiopia");

        PhoneNumbersFetchingResponse response = new PhoneNumbersFetchingProcessor(request, phoneNumberRepo).execute();

        int ethiopiaCustomersSize = (int) customers
                .stream()
                .filter(customer -> customer.getPhone().matches(ethiopiaRegex))
                .count();

        Assert.assertEquals(ethiopiaCustomersSize, response.getCustomerPhonesList().size());

        Assert.assertEquals(firstCustomer.getPhone(), response.getCustomerPhonesList().get(0).getPhone());
        Assert.assertEquals(firstCustomer.getName(), response.getCustomerPhonesList().get(0).getName());
        Assert.assertEquals(firstCustomer.getId(), response.getCustomerPhonesList().get(0).getId());

        Assert.assertEquals(fourthCustomer.getPhone(), response.getCustomerPhonesList().get(1).getPhone());
        Assert.assertEquals(fourthCustomer.getName(), response.getCustomerPhonesList().get(1).getName());
        Assert.assertEquals(fourthCustomer.getId(), response.getCustomerPhonesList().get(1).getId());
    }

    @Test
    void fetchingPhonesForMoroccoWorks() {
        String moroccoRegex = "\\(212\\) ?[5-9]\\d{8}$";

        Customer firstCustomer = new Customer(1, "Morocco Test 1", "(212) 698054317");
        Customer secondCustomer = new Customer(2, "Test 2", "(258) 847651504");
        Customer thirdCustomer = new Customer(3, "Test 3", "(256) 775069443");
        Customer fourthCustomer = new Customer(4, "Morocco Test 2", "(212) 691933626");

        List<Customer> customers = List.of(firstCustomer, secondCustomer, thirdCustomer, fourthCustomer);

        Mockito.when(phoneNumberRepo.findAll()).thenReturn(customers);

        PhoneNumbersFetchingRequest request = new PhoneNumbersFetchingRequest("Morocco");

        PhoneNumbersFetchingResponse response = new PhoneNumbersFetchingProcessor(request, phoneNumberRepo).execute();

        int moroccoCustomersSize = (int) customers
                .stream()
                .filter(customer -> customer.getPhone().matches(moroccoRegex))
                .count();

        Assert.assertEquals(moroccoCustomersSize, response.getCustomerPhonesList().size());

        Assert.assertEquals(firstCustomer.getPhone(), response.getCustomerPhonesList().get(0).getPhone());
        Assert.assertEquals(firstCustomer.getName(), response.getCustomerPhonesList().get(0).getName());
        Assert.assertEquals(firstCustomer.getId(), response.getCustomerPhonesList().get(0).getId());

        Assert.assertEquals(fourthCustomer.getPhone(), response.getCustomerPhonesList().get(1).getPhone());
        Assert.assertEquals(fourthCustomer.getName(), response.getCustomerPhonesList().get(1).getName());
        Assert.assertEquals(fourthCustomer.getId(), response.getCustomerPhonesList().get(1).getId());
    }

    @Test
    void fetchingPhonesForMozambiqueWorks() {
        String mozambiqueRegex = "\\(258\\) ?[28]\\d{7,8}$";

        Customer firstCustomer = new Customer(1, "Mozambique Test 1", "(258) 847651504");
        Customer secondCustomer = new Customer(2, "Test 2", "(212) 698054317");
        Customer thirdCustomer = new Customer(3, "Test 3", "(256) 775069443");
        Customer fourthCustomer = new Customer(4, "Mozambique Test 2", "(258) 846565883");

        List<Customer> customers = List.of(firstCustomer, secondCustomer, thirdCustomer, fourthCustomer);

        Mockito.when(phoneNumberRepo.findAll()).thenReturn(customers);

        PhoneNumbersFetchingRequest request = new PhoneNumbersFetchingRequest("Mozambique");

        PhoneNumbersFetchingResponse response = new PhoneNumbersFetchingProcessor(request, phoneNumberRepo).execute();

        int mozambiqueCustomersSize = (int) customers
                .stream()
                .filter(customer -> customer.getPhone().matches(mozambiqueRegex))
                .count();

        Assert.assertEquals(mozambiqueCustomersSize, response.getCustomerPhonesList().size());

        Assert.assertEquals(firstCustomer.getPhone(), response.getCustomerPhonesList().get(0).getPhone());
        Assert.assertEquals(firstCustomer.getName(), response.getCustomerPhonesList().get(0).getName());
        Assert.assertEquals(firstCustomer.getId(), response.getCustomerPhonesList().get(0).getId());

        Assert.assertEquals(fourthCustomer.getPhone(), response.getCustomerPhonesList().get(1).getPhone());
        Assert.assertEquals(fourthCustomer.getName(), response.getCustomerPhonesList().get(1).getName());
        Assert.assertEquals(fourthCustomer.getId(), response.getCustomerPhonesList().get(1).getId());
    }

    @Test
    void fetchingPhonesForUgandaWorks() {
        String ugandaRegex = "\\(256\\) ?\\d{9}$";

        Customer firstCustomer = new Customer(1, "Uganda Test 1", "(256) 775069443");
        Customer secondCustomer = new Customer(2, "Test 2", "(258) 847651504");
        Customer thirdCustomer = new Customer(3, "Test 3", "(212) 698054317");
        Customer fourthCustomer = new Customer(4, "Uganda Test 2", "(256) 704244430");

        List<Customer> customers = List.of(firstCustomer, secondCustomer, thirdCustomer, fourthCustomer);

        Mockito.when(phoneNumberRepo.findAll()).thenReturn(customers);

        PhoneNumbersFetchingRequest request = new PhoneNumbersFetchingRequest("Uganda");

        PhoneNumbersFetchingResponse response = new PhoneNumbersFetchingProcessor(request, phoneNumberRepo).execute();

        int ugandaCustomersSize = (int) customers
                .stream()
                .filter(customer -> customer.getPhone().matches(ugandaRegex))
                .count();

        Assert.assertEquals(ugandaCustomersSize, response.getCustomerPhonesList().size());

        Assert.assertEquals(firstCustomer.getPhone(), response.getCustomerPhonesList().get(0).getPhone());
        Assert.assertEquals(firstCustomer.getName(), response.getCustomerPhonesList().get(0).getName());
        Assert.assertEquals(firstCustomer.getId(), response.getCustomerPhonesList().get(0).getId());

        Assert.assertEquals(fourthCustomer.getPhone(), response.getCustomerPhonesList().get(1).getPhone());
        Assert.assertEquals(fourthCustomer.getName(), response.getCustomerPhonesList().get(1).getName());
        Assert.assertEquals(fourthCustomer.getId(), response.getCustomerPhonesList().get(1).getId());
    }
}
