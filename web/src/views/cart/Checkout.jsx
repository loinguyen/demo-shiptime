import React, { useRef, useState } from "react";
import { connect } from "react-redux";
import Address from "../../components/shipment/Address";
import PackageDetail from "../../components/shipment/PackageDetail";
import Carrier from "../../components/shipment/Carrier";
import ShipmentDetail from "../../components/shipment/ShipmentDetail";
import Summarize from "../../components/shipment/Summarize";
import { Button, Steps, DatePicker, notification } from 'antd';
import { ReactComponent as IconExclamation } from "bootstrap-icons/icons/exclamation-circle.svg";
import dayjs from 'dayjs';
import { URL } from "../../url/UrlConstant"

const CheckoutView = (props) => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [current, setCurrent] = useState(0);
  const [childState, setChildState] = useState({
    addressState: {},
    packageState: {},
    carrierState: {},
    shipmentState: {},
    summarizeState: {}
  })
  const [shipDate, setShipDate] = useState(dayjs().format('YYYY-MM-DD'))
  const addRef = useRef(null);
  const packRef = useRef(null);
  const carrierRef = useRef(null);
  const shipmentRef = useRef(null);

  const nextStep = () => {
    setCurrent(current + 1);
  }
  const nextToShipmentStep = (carrierState) => {
    childState.carrierState = carrierState;
    setChildState(childState);
    nextStep();
  }

  const steps = [
    {
      title: 'Address Detail',
      content: <Address ref={addRef} stateData={childState.addressState} />
    },
    {
      title: 'Shipment Detail',
      content: <PackageDetail ref={packRef} stateData={childState.packageState} />
    },
    {
      title: 'Choose Carrier',
      content: <Carrier ref={carrierRef} stateData={childState.carrierState} nextAction={nextToShipmentStep} />
    },
    {
      title: 'Pickup Detail',
      content: <ShipmentDetail ref={shipmentRef} stateData={childState.shipmentState} />
    },
    {
      title: 'Summarize',
      content: <Summarize stateData={childState.summarizeState} />
    },
  ];

  const items = steps.map((item) => ({ key: item.title, title: item.title }));

  const nextToPackageDetail = () => {
    childState.addressState = addRef.current.state;
    setChildState(childState)
    nextStep()
  };

  const nextToCarrier = () => {
    childState.packageState = packRef.current.state;
    setChildState(childState);
    const errorList = validatePackageData();
    if (errorList.length > 0) {
      openNotification(errorList)
      return;
    }
    getRateService(nextStep);
  };

  const prev = () => {
    setCurrent(current - 1);
  };

  const validatePackageData = () => {
    const errorList = [];
    const packageData = childState.packageState;
    if (packageData.height === '' || packageData.height < 0) {
      errorList.push("Package Height must be greater than 0")
    }
    if (packageData.length === '' || packageData.length < 0) {
      errorList.push("Package Length must be greater than 0")
    }
    if (packageData.width === '' || packageData.width < 0) {
      errorList.push("Package Width must be greater than 0")
    }
    if (packageData.weight === '' || packageData.weight < 0) {
      errorList.push("Package Weight must be greater than 0")
    }

    return errorList;
  }

  const getRateService = async (nextAction) => {
    setLoading(true);
    try {
      const postData = buildRequestDTO();
      const response = await fetch(URL.GET_RATE, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(postData),
      });

      if (!response.ok) {
        const errorMessage = await response.json();
        throw new Error(errorMessage.messages);
      }

      const result = await response.json();
      childState.carrierState.listRates = result.listRates;
      setChildState(childState);
      nextAction();
    } catch (error) {
      if (error.message === "Failed to fetch") {
        openNotification(["There are unexpected error occuring, Please try again later"]);
      } else {
        openNotification(error.messages);
      }
    } finally {
      setLoading(false);
    }
  }

  const submitPackage = async () => {
    childState.shipmentState = shipmentRef.current.state;
    setChildState(childState);
    setLoading(true);
    try {
      const postData = buildCreatePackageRequestDTO();
      console.log(postData);
      const response = await fetch(URL.CREATE_SHIPMENT, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(postData),
      });

      if (!response.ok) {
        const errorMessage = await response.json();
        throw new Error(errorMessage.messages);
      }

      const result = await response.json();
      childState.summarizeState = result;
      setChildState(childState);
      nextStep()
    } catch (error) {
      if (error.message === "Failed to fetch") {
        openNotification(["There are unexpected error occuring, Please try again later"]);
      } else {
        openNotification(error.messages);
      }
    } finally {
      setLoading(false);
    }
  }
  const disabledDate = (current) => {
    // Can not select days before today
    return current < dayjs().startOf('day');
  };

  const shipDateChange = (date, dateString) => {
    if (dateString) {
      setShipDate(dateString);
    }

  }

  const buildRequestDTO = () => {
    return {
      from: {
        company: childState.addressState.from_company,
        streetAdd: childState.addressState.from_streetAdd,
        streetAdd2: childState.addressState.from_streetAdd2,
        city: childState.addressState.from_city,
        countryCode: childState.addressState.from_countryCode,
        state: childState.addressState.from_state,
        postalCode: childState.addressState.from_postalCode,
        attention: childState.addressState.from_attention,
        email: childState.addressState.from_email,
        phone: childState.addressState.from_phone
      },
      to: {
        company: childState.addressState.to_company,
        streetAdd: childState.addressState.to_streetAdd,
        streetAdd2: childState.addressState.to_streetAdd2,
        city: childState.addressState.to_city,
        countryCode: childState.addressState.to_countryCode,
        state: childState.addressState.to_state,
        postalCode: childState.addressState.to_postalCode,
        attention: childState.addressState.to_attention,
        email: childState.addressState.to_email,
        phone: childState.addressState.to_phone
      },
      shipDate: shipDate,
      packageDetail: {
        length: childState.packageState.length,
        width: childState.packageState.width,
        height: childState.packageState.height,
        weight: childState.packageState.weight,
        value: childState.packageState.pkgValue,
        description: childState.packageState.description
      }
    }
  }

  const buildCreatePackageRequestDTO = () => {
    var rateRequest = buildRequestDTO();
    return {
      carrierId: childState.carrierState.carrierId,
      serviceId: childState.carrierState.servicesId,
      rateRequest: rateRequest,
      shipmentDetail: childState.shipmentState
    }
  }

  const openNotification = (errorMessages) => {

    notification.open({
      message: <span style={{ color: "red" }}>Error</span>,
      description:
        <ul>
          {
            errorMessages.map((message, index) =>
              <React.Fragment>
                <li key={index} className="pb-1"><IconExclamation className="i-va pe-1" style={{ color: "red" }} />{message}</li>
              </React.Fragment>
            )
          }
        </ul>,
      placement: 'bottom',
      duration: null
    });
  };

  return (
    <React.Fragment>
      <div className="container py-4">
        <div className="row">
          <Steps current={current} items={items} />
        </div>
        <div className="row pt-3">
          <div style={{}}>
            {steps[current].content}
          </div>
        </div>
        <div className="d-flex" style={{ justifyContent: "flex-end" }} >
          {current > 0 && current < steps.length - 1 && (
            <Button style={{ margin: '0 8px' }} onClick={() => prev()} disabled={loading}>
              Previous
            </Button>
          )}
          {current === 0 && (
            <React.Fragment>
              <div className="me-2">
                <label className="pe-2">What's the date you plan to ship the item? </label>
                <DatePicker
                  format="YYYY-MM-DD"
                  disabledDate={disabledDate}
                  value={dayjs(shipDate, 'YYYY-MM-DD')}
                  onChange={shipDateChange}
                />
              </div>
              <Button type="primary" onClick={() => nextToPackageDetail()}>
                Shipment Detail
              </Button>
            </React.Fragment>
          )}
          {current === 1 && (
            <Button type="primary" onClick={() => nextToCarrier()} loading={loading}>
              Choose Carrier
            </Button>
          )}
          {current === 3 && (
            <Button type="primary" onClick={() => submitPackage()} loading={loading}>
              Submit Finalize
            </Button>
          )}
          {current === steps.length - 1 && (
            <Button type="primary" onClick={() => window.location.reload()}>
              Done
            </Button>
          )}
        </div>
      </div>
    </React.Fragment>
  );
}

const mapStateToProps = state => {
  return {
    cart: state._todoProduct.carts
  }
}
export default connect(mapStateToProps, null)(CheckoutView)
