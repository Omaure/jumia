package com.jumia.phoneNumbers.core.processor;

import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingRequest;
import com.jumia.PhoneNumber.core.exception.CountryDoesNotExistException;
import com.jumia.PhoneNumber.core.processor.PhoneNumbersFetchingProcessor;
import com.jumia.PhoneNumber.core.repo.PhoneNumberRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

}
