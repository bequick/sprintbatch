package com.example.springbatchdemo.conf;

import com.example.springbatchdemo.model.Credit;
import com.example.springbatchdemo.separator.SkipBlankLinePolicy;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration extends DefaultBatchConfigurer {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Value("${app.awsServices.bucket.file}")
    private String file;

    @Value("${jobparameters.date:#{null}}")
    @StepScope
    private String initialDate;

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Credit, Credit>chunk(5)
                .reader(reader())
                .writer(writer())
                .build();
    }


    @Bean
    public FlatFileItemReader<Credit> reader() {
        System.out.println("===========================================================");
        System.out.println("reader");
        try {
            return new FlatFileItemReaderBuilder<Credit>()
                    .name("creditItemReader")
                    .resource(new FileSystemResource("src/main/java/com/example/springbatchdemo/input/file.csv"))
                    .linesToSkip(1)
                    .recordSeparatorPolicy(new SkipBlankLinePolicy())
                    .delimited()
                    .names("Correlativo", "CREDITO", "Moneda", "RUT", "Dv", "Nombre", "Oficina", "NombreOficina", "Cuotas", "FeCurse", "Producto", "Tipo", "Tasa", "MontoCuota", "MontoCredito", "Familia", "CodProducto", "CANAL", "CanalIngreso", "NroGarantia", "Spare1", "Spare2", "ULTIMACUOTA", "PROFESION", "ESTADOCIVIL", "IDCLIENTE", "CuotasOriginales", "TasaOriginal", "FechaOriginal", "SALDO_ADEUDADO", "PRIMER_VCMTO", "NroReprogramacion", "DIRECCION", "FECHA_DOCUMENTO")
                    .fieldSetMapper(new BeanWrapperFieldSetMapper<Credit>() {{
                        setTargetType(Credit.class);
                    }})
                    .build();
        } catch (Exception e) {
            System.out.println("===========================================================");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Bean
    public ConsoleItemWriter<Credit> writer(){
        System.out.println("===========================================================");
        System.out.println("writer");
        return new ConsoleItemWriter<Credit>();

    }


}
