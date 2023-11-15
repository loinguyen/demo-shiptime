
import React, { Component } from "react";
import { ReactComponent as IconTruck } from "bootstrap-icons/icons/truck.svg";
import { Button } from "antd";
class Carrier extends Component {

    constructor(props) {
        super(props);
        this.state = {
            listRates: props.stateData.listRates || [],
            carrierId: props.stateData.carrierId || '',
            servicesId: props.stateData.servicesId || ''
        }
    }

    selectCarrier = (event) => {
        var item = this.state.listRates[event.currentTarget.value];
        this.setState({ carrierId: item.carrierId, servicesId: item.servicesId });
        this.props.nextAction({listRates: this.state.listRates, carrierId: item.carrierId, servicesId: item.servicesId });
    }

    render() {
        return (
            <React.Fragment>
                <div className="col-md-12 order-2 order-lg-1">
                    <div className="card mb-3">
                        <div className="card-header brand_background_color_light">
                            <IconTruck className="i-va" /> Carrier Services
                        </div>
                        <div className="card-body" style={{ width: '100%', overflow: 'auto' }}>
                            <div className="row g-0 w-100 text-center fw-bold" style={{ backgroundColor: "#e9ecef", height: "50px", alignItems: "center" }}>
                                <div className="col-2">Carrier</div>
                                <div className="col-2">Service</div>
                                <div className="col-1">Estimated Delivery</div>
                                <div className="col-4">Price ($)</div>
                                <div className="col-2">Action</div>
                            </div>
                            {this.state.listRates.map((item, index) =>
                                <div key={index} className="row my-2 py-1 g-0 w-100 text-center card-table-row" style={{ alignItems: "center" }}>
                                    <div className="col-2">{item.carrier}</div>
                                    <div className="col-2">{item.service}</div>
                                    <div className="col-1">{item.estimateDelivery}</div>
                                    <div className="col-4">{item.totalPrice} {item.currency}</div>
                                    <Button className="col-2" type="primary" value={index} onClick={this.selectCarrier}>
                                        Select
                                    </Button>
                                </div>
                            )}
                        </div>

                    </div>
                </div>
            </React.Fragment>
        )
    }
}

export default Carrier