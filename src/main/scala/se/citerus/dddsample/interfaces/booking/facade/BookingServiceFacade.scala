package se.citerus.dddsample.interfaces.booking.facade

import se.citerus.dddsample.interfaces.booking.facade.dto.CargoRoutingDTO;
import se.citerus.dddsample.interfaces.booking.facade.dto.LocationDTO;
import se.citerus.dddsample.interfaces.booking.facade.dto.RouteCandidateDTO;

import java.util.Date;

/**
 * This facade shields the domain layer - model, services, repositories -
 * from concerns about such things as the user interface and remoting.
 */
trait BookingServiceFacade {
  def bookNewCargo(origin: String, destination: String, arrivalDeadline: Date): String;

  def loadCargoForRouting(trackingId: String): CargoRoutingDTO

  def assignCargoToRoute(trackingId: String, route: RouteCandidateDTO): Unit;

  def changeDestination(trackingId: String, destinationUnLocode: String): Unit;

  def requestPossibleRoutesForCargo(trackingId: String): List[RouteCandidateDTO]

  def listShippingLocations(): List[LocationDTO]

  def listAllCargos(): List[CargoRoutingDTO]
}