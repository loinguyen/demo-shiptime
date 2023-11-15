
import React, { Component } from "react";
import { ReactComponent as IconBag } from "bootstrap-icons/icons/bag-dash.svg";
import { DatePicker, TimePicker } from "antd";
import {data as locationData} from '../../data/pickupLocationData'
import dayjs from "dayjs";
class ShipmentDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            pickupDate: props.stateData.pickupDate || dayjs().format('YYYY-MM-DD'),
            fromTime: props.stateData.fromTime || dayjs('10:00', 'HH:mm').format('HH:mm'),
            toTime: props.stateData.toTime || dayjs('14:00', 'HH:mm').format('HH:mm'),
            location: props.stateData.location || locationData[0].value
        }
    }

    disabledDate = (current) => {
        // Can not select days before today
        return current < dayjs().startOf('day');
    };

    pickupDateChange = (date, dateString) => {
        if (dateString) {
            this.setState({pickupDate: dateString});
        }
    }

    disabledFromHours = () => {
        let hours = [];
        for (let i = 0; i < 24; i++) {
          if (i < 10 || i > 17) { // Disable hours outside 9:00 to 17:59
            hours.push(i);
          }
        }
        return {
            disabledHours: () => hours
        };
    };

    pickupFromTimeChange = (time, timeString) => {
        console.log(time.format('HH:mm'));
        this.setState({fromTime: timeString});
    }

    disabledToHours = () => {
        let hours = [];
        for (let i = 0; i < 24; i++) {
          if (i < 14 || i > 19) { // Disable hours outside 14:00 to 19:00
            hours.push(i);
          }
        }
        return {
            disabledHours: () => hours
        };
    };

    pickupToTimeChange = (time, timeString) => {
        console.log(time);
        this.setState({toTime: timeString});
    }

    pickupLocationChange = (event) => {
        this.setState({location: event.target.value.value})
    }

    render() {
        return (
            <React.Fragment>
                <div className="col-md-12 order-2 order-lg-1">
                    <div className="card mb-3">
                        <div className="card-header brand_background_color_light">
                            <IconBag className="i-va" /> Shipping Information
                        </div>
                        <div className="card-body">
                            <div className="row g-3">
                                <div className="d-flex flex-column col-md-3">
                                    <label className="mb-1 ps-1 fw-bold">Pickup Date</label>
                                    <DatePicker
                                        format="YYYY-MM-DD"
                                        disabledDate={this.disabledDate}
                                        value={dayjs(this.state.pickupDate, 'YYYY-MM-DD')}
                                        onChange={this.pickupDateChange}
                                    />
                                </div>
                                <div className="d-flex flex-column col-md-3">
                                    <label className="mb-1 ps-1 fw-bold">From Time</label>
                                    <TimePicker
                                        format="HH:mm"
                                        minuteStep={15}
                                        allowClear={false}
                                        disabledTime={this.disabledFromHours}
                                        hideDisabledOptions={true}
                                        value={dayjs(this.state.fromTime, 'HH:mm')}
                                        onChange={this.pickupFromTimeChange}
                                    />
                                </div>
                                <div className="d-flex flex-column col-md-3">
                                    <label className="mb-1 ps-1 fw-bold">To Time</label>
                                    <TimePicker
                                        format="HH:mm"
                                        minuteStep={15}
                                        allowClear={false}
                                        disabledTime={this.disabledToHours}
                                        hideDisabledOptions={true}
                                        value={dayjs(this.state.toTime, 'HH:mm')}
                                        onChange={this.pickupToTimeChange}
                                    />
                                </div>
                                <div className="d-flex flex-column col-md-3">
                                    <label className="mb-1 ps-1 fw-bold">Pickup Location</label>
                                    <select className="form-select"
                                        value={this.state.location}
                                        onChange={this.handleChange} required>
                                        {
                                            locationData.map((item, index) =>
                                                <option key={item.value} value={item.value}>{item.name}</option>
                                            )
                                        }
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        )
    }
}

export default ShipmentDetail;