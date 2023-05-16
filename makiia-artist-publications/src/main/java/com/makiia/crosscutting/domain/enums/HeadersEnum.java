package com.makiia.crosscutting.domain.enums;

import lombok.Getter;

@Getter
public enum HeadersEnum {
    PROCESO("EN_PROCESO"), CREDIT_NAME_TYPE("CREDIT_NAME_TYPE"), DEFAULT("DEFAULT"), ONLY_BAD("ONLY_BAD"),
    VALIDATION_MAL("Validaciones de registros herredos"),
    DESCRIPTION_VALIDATION_MAL("El maestro que se esta procesando todos sus registros precentan error"),
    DESCRIPTION_MAIL(""), ERROR_EN_PRECARGUE("ERROR_EN_PRECARGUE"), ONLY_GOOD("ONLY_GOOD"),
    BAD_AND_GOOD("BAD_AND_GOOD"), SWITCH_FLOW_MASTER("SWITCH_FLOW_MASTER"), ERROR_DATA("ERROR DATA"),
    ESTRUCTURA_ERROR("ESTRUCTURA ERROR"), CORRECTO_DATA("CORRECTO DATA"), BOX_TYPE("BOX_TYPE"),
    NAME_MASTER("name_master"), LEGAL_NAME("legalName"), LEGALNAME("legal_name"), MICROBUS_FLOW("micro_bus_flow"),
    TRANSACTION_ID("transaction_id"), FILE_NAME("file_name"), COMPANY("company"), ACCOUNT("account"), COUNTRY("CO"),
    CHANNEL("channel"), COMMAND_ID("commandId"), RENAME("rename"), CONTINUE_FLOW("continueFlow"),
    ORIGINAL_FILENAME("originalFileName"), ORIGINAL_NAMEATTACHED("originalNameAttach"),
    DOCUMENT_STORAGEID("documentStorageId"), FILE_PREFIX_OUTBOUND("file_prefix_outbound"),
    DOCUMENT_TYPE("documentType"), DOCUMENT_ID("documentId"), CUDE_STRING("cudeString"),
    UNSIGNED_DOCUMENTSTORAGE("unsignedXmlStorageId"), QR_CODE_STORAGE_ID("qrCodeStorageId"),
    RESPONSE_DATE_DIAN("responseDateDian"), IS_VALID_DOCUMENT("is_valid_document"),
    ATTACHMENT_DOCUMENTS_ID("attachmentsDocumentId"), ZIP("Zip"), PDF("PDF"), DOCUMENT_HEADER("attachmentsDocumentId"),
    RESPONSE_DIAN("DIAN_RESULT"), XML_DOCUMENT("documentXml"), DIAN_RESPONSE("dianValue"), SIGNED_XML("signed_xml"),
    PROCESS_FINISH("PROCESS_FINISH"), ATTACHED_DOCUMENT_UNSIGNED("ATTACHED_DOCUMENT_UNSIGNED"),
    ATTACHED_DOCUMENT_SIGNED("ATTACHED_DOCUMENT_SIGNED"), ATTACHED_DOCUMENT("ATTACHED_DOCUMENT"),
    SOFTWARE_ID("idSoftware"), TEST_SET_ID("testId"), METHOD_DIAN("methodDian"), SOFTWARE_PIN("pinSoftware"),
    PATH_PDF_DS("pathPdf"), PATH_XML_MANDATO_DS("pathXml"), THUMBPRINT("thumbPrint"), MANDATO_CODE("MND"),
    IDCOSTUMER("idCostumer"), KEY("key"), PASSWORD("password"), CERTIFICATE("certificate"),
    CERTIFICATE_TYPE("certificateType"), SERIALNUMBER("serialNumber"),
    INITIAL_CERTIFICATE_DATE("initialCertificateDate"), FINAL_CERTIFICATE_DATE("finalCertificateDate"),
    REGISTRATION_DATE("registrationDate"), SERVICE("service"), XML_DOCUMENT_TRANSFORMED("unsignedDocumentXml"),
    DIGITAL_CERTIFICATE_STATUS("digitalCertificateStatus"), DOCUMENT_STATUS("documentStatus"),
    TYPE_DOCUMENT("typeDocument"), DOCUMENT_PROCESS("documentProcess"), CODE_MESSAGE("MSS-BUS"),
    CODE_XML_APR("XML-APR"), DESCRIPTION_XML_APR("XML-APR"), CODE_ATTACHED("XML-ATTACHED"),
    DESCRIPTION_ATTACHED("XML-ATTACHED"), EXTENSION_FILE("extensionContent"), EXTENSION_FILE_JSON("JSON"),
    DOCUMENT_PROCESS_CODE_PARENT("PCS-EVT"), DOCUMENT_STATUS_CODE_PARENT("STA-PCS"),
    DOCUMENT_TYPE_CODE_PARENT("TP-FILE-CHN"), JSON_MANDATO("jsonMandato"), COMPANY_NAME("companyName"),
    COMPANY_IDENTIFICATION("companyId"), VERIFICATION_DIGIT("verificationDigit"), PAY_INFORMATION("InformacionPagos"),
    INFORMATION_TO_PAY("InformacionParaelPago"), MESURE_INFORMATION_PRECAUTIONARY("InformacionMedidaCautelar"),
    NEGOTIATION_INFORMATION("InformacionNegociacion"), INFORMATION_AVAL("InformacionAvalar"),
    INFORMATION_INS("ConstanciadePagos"), CERTIFICATE_SIGNATURE("certificateSignature"), LIFECY_CLE_ID_CODE("5"),
    DOCUMENT_STATUS_CODE_RESULT("STATUS_CODE"), DOCUMENT_STATUS_DESCRIPTION_RESULT("STATUS_DESCRIPTION"),
    TERMINATION_MANDATO("MNDTRM"), TECNOLOGY_PROVIDER("technologyProvider"), ID_EVENT("id_event"), IDEVENT("idEvent"),
    FILES("files"), EVENTS_XML("events-xml"), TRANSFORMED("transformed"), IN("IN"), XML_CARVAJAL("XML_CARVAJAL"),
    DIAN_RESULT("DIAN_RESULT"), FILE_CONTENT("file_content"), DIAN_VALUE("dian_value"), XML("xml"),
    XML_EVENTS("XML_EVENTS"), JSON_EVENTS("JSON_EVENTS"), CUFE_STRING("cufeString"),
    DIGITAL_CERTIFICATE_CODE("digital_certificate_code"), SEND_OUTBOUND_ACTIVE("send_outbound_active"),
    RESULT_DIAN("result_dian"), DIAN_RESULT_FILEDATA("dian_result_filedata"),
    APPLICATION_RESPONSE("applicationResponse"), ATTACH_DOCUMENT_ACTIVE("attach_document_active"),
    PROCESSED_SUCCESS("processed_success"), GENERATE_PDF("generatePdf"), ATTACH_DOCUMENT("attachDocument"),
    PDF_DOCUMENT("pdfDocument"), TEMPLATE("template"), SFTP_AWS("SFTP-AWS"), TYPE_IN("IN"), APP_RESPONSE("appResponse"),
    SERVICE_TYPE("RADIAN"), ERROR_EVENT_WITHOUT_TRANSACTION("ERROR_EVENT_WITHOUT_TRANSACTION"),
    IS_EVENTVALID("IS_EVENTVALID"),
    MESSAGE_EVENT_WITHOUT("El evento no tiene transacción, para poder generar el archivo log"),
    PREFIX_ERROR("radian/documents/error"), CUSTOMIZATION_ID_MESSAGE("Falta el valor CustomizationID"),
    NOT_FOUNT_ID_TAG("Falta el tag ID"), NOT_FOUNT_ID("Falta el valor ID"),
    NOT_FOUNT_ISSUE_DATE("Falta tag de IssueDate"), NOT_FOUNT_ISSUE_TIME("Falta tag de IssueTime"),
    NOT_FOUNT_CUSTOMIZATION_ID_TAG("Falta tag CustomizationID"),
    NOT_FOUNT_DOCUMENT_RESPONSE_TAG("Falta tag Document response"),
    DOCUMENT_REFERENCE("Falta id del documento referente"), NOT_FOUNT_UUID("Falta el UUID del documento referente"),
    NOT_FOUNT_DOCUMENT_RESPONSE("El documento no tiene el DocumentResponse"),
    IS_EMPTY_DOCUMENT_RESPONSE("El documento tiene el DocumentResponse vacio"),
    IS_NULL_DOCUMENT_RESPONSE("El documento tiene el DocumentResponse nulo"),
    IS_NULL_DOCUMENT_REFERENCE("El documento tiene un documentReference nulo en el DocumentResponse"),
    IS_NULL_UUID("El documento tiene EL UUID del documentRefence nulo"),
    NOT_FOUNT_ID_COMPANY("El documento no tiene el ID de la compañia"),
    ACCOUNT_VALIDATION("El nit: {0} del evento enviado no corresponde a la cuenta "),
    NOT_FOUNT_REGISTRATION_NAME("El documento no tiene el tag RegistrationName"),
    NOT_FOUNT_TAX_SCHEME("No existe la etiqueta Party Tax Scheme"),
    NOT_FOUNT_SENDER_PARTY_LABEL("No exite la etiqueta Sender Party"),
    NOT_FOUNT_RECEIVER_PARTY_LABEL("No exite la etiqueta Receiver Party"), MESSAGE_PROCESANDO("Procesando"),
    START_CTC("Inicio procesamiento CTS"), EXTERNAL("EXTERNAL"),
    MESSAGE_FINAL_LOG_ERROR(
            "Proceso finalizado ya que el documento entrante lleva errores de negocio, revisar log de errores"),
    GENERATE_LOG("generateLog"), BASE_64_LOG("base64Log"), NOTIFICATION_ATTACHMENT("notificationAttachment"),
    SFTP_CHANNEL("SFTP-AWS"), WEB_CHANNEL("web"), TYPE_CHANNEL_IN("IN"), FILE_NAME_ATTACH("fileName");

    private final String name;

    HeadersEnum(final String name) {
        this.name = name;
    }
}