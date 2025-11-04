/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author Lav
 */
@Path("generickikontrolerserverport")
public class GenerickiKontrolerServerPort {

    private Server_client.GenerickiKontrolerServer port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenerickiKontrolerServerPort
     */
    public GenerickiKontrolerServerPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method vratiRangListu
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.TransferObjekatRangLista>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("vratiranglistu/")
    public JAXBElement<Server_client.TransferObjekatRangLista> postVratiRangListu(JAXBElement<Server_client.TransferObjekatRangLista> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.TransferObjekatRangLista result = port.vratiRangListu(arg0.getValue());
                return new JAXBElement<Server_client.TransferObjekatRangLista>(new QName("http//Server_client/", "transferobjekatranglista"), Server_client.TransferObjekatRangLista.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method izvediPotez
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.TransferObjekatPartija>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("izvedipotez/")
    public JAXBElement<Server_client.TransferObjekatPartija> postIzvediPotez(JAXBElement<Server_client.TransferObjekatPartija> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.TransferObjekatPartija result = port.izvediPotez(arg0.getValue());
                return new JAXBElement<Server_client.TransferObjekatPartija>(new QName("http//Server_client/", "transferobjekatpartija"), Server_client.TransferObjekatPartija.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method kreirajDK
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.GenerickiTransferObjekat>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("kreirajdk/")
    public JAXBElement<Server_client.GenerickiTransferObjekat> postKreirajDK(JAXBElement<Server_client.GenerickiTransferObjekat> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.GenerickiTransferObjekat result = port.kreirajDK(arg0.getValue());
                return new JAXBElement<Server_client.GenerickiTransferObjekat>(new QName("http//Server_client/", "generickitransferobjekat"), Server_client.GenerickiTransferObjekat.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method nadjiDk
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.GenerickiTransferObjekat>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("nadjidk/")
    public JAXBElement<Server_client.GenerickiTransferObjekat> postNadjiDk(JAXBElement<Server_client.GenerickiTransferObjekat> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.GenerickiTransferObjekat result = port.nadjiDk(arg0.getValue());
                return new JAXBElement<Server_client.GenerickiTransferObjekat>(new QName("http//Server_client/", "generickitransferobjekat"), Server_client.GenerickiTransferObjekat.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method izmeniDK
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.GenerickiTransferObjekat>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("izmenidk/")
    public JAXBElement<Server_client.GenerickiTransferObjekat> postIzmeniDK(JAXBElement<Server_client.GenerickiTransferObjekat> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.GenerickiTransferObjekat result = port.izmeniDK(arg0.getValue());
                return new JAXBElement<Server_client.GenerickiTransferObjekat>(new QName("http//Server_client/", "generickitransferobjekat"), Server_client.GenerickiTransferObjekat.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method obrisiDK
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.GenerickiTransferObjekat>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("obrisidk/")
    public JAXBElement<Server_client.GenerickiTransferObjekat> postObrisiDK(JAXBElement<Server_client.GenerickiTransferObjekat> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.GenerickiTransferObjekat result = port.obrisiDK(arg0.getValue());
                return new JAXBElement<Server_client.GenerickiTransferObjekat>(new QName("http//Server_client/", "generickitransferobjekat"), Server_client.GenerickiTransferObjekat.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method prijaviDK
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.TransferObjekatKorisnikLogin>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("prijavidk/")
    public JAXBElement<Server_client.TransferObjekatKorisnikLogin> postPrijaviDK(JAXBElement<Server_client.TransferObjekatKorisnikLogin> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.TransferObjekatKorisnikLogin result = port.prijaviDK(arg0.getValue());
                return new JAXBElement<Server_client.TransferObjekatKorisnikLogin>(new QName("http//Server_client/", "transferobjekatkorisniklogin"), Server_client.TransferObjekatKorisnikLogin.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private Server_client.GenerickiKontrolerServer getPort() {
        try {
            // Call Web Service Operation
            Server_client.GenerickiKontrolerServer_Service service = new Server_client.GenerickiKontrolerServer_Service();
            Server_client.GenerickiKontrolerServer p = service.getGenerickiKontrolerServerPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
