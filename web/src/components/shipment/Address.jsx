import React, { Component } from "react";
import { ReactComponent as IconTruck } from "bootstrap-icons/icons/truck.svg";
import { data } from "../../data/stateData";

class Address extends Component {
    constructor(props) {
        super(props);
        this.state = {
            from_company: props.stateData.from_company  || '',
            from_streetAdd: props.stateData.from_streetAdd || '',
            from_streetAdd2: props.stateData.from_streetAdd2 || '',
            from_city: props.stateData.from_city || '',
            from_countryCode: props.stateData.from_countryCode || '',
            from_state: props.stateData.from_state || '',
            from_postalCode: props.stateData.from_postalCode || '',
            from_attention: props.stateData.from_attention || '',
            from_email: props.stateData.from_email || '',
            from_phone: props.stateData.from_phone || '',

            to_company: props.stateData.to_company || '',
            to_streetAdd: props.stateData.to_streetAdd || '',
            to_streetAdd2: props.stateData.to_streetAdd2 || '',
            to_city: props.stateData.to_city || '',
            to_countryCode: props.stateData.to_countryCode || '',
            to_state: props.stateData.to_state || '',
            to_postalCode: props.stateData.to_postalCode || '',
            to_attention: props.stateData.to_attention || '',
            to_email: props.stateData.to_email || '',
            to_phone: props.stateData.to_phone || '',

            isValid: props.stateData.isValid || false,
            fromCountryStateList: props.stateData.fromCountryStateList || [],
            toCountryStateList: props.stateData.toCountryStateList || [],
        };
    }

    handleChange = (event) => {
        this.setState({ [event.target.name]: event.target.value });
    }

    handleCountryChange = (event) => {
        this.handleChange(event);
        if (event.target.name === 'from_countryCode') {
            this.setState({ fromCountryStateList: data[event.target.value] });
        } else {
            this.setState({ toCountryStateList: data[event.target.value] });
        }

    }

    render() {
        return (
            <React.Fragment>
                <div className="col-md-12 order-2 order-lg-1">
                    <div className="card mb-3">
                        <div className="card-header brand_background_color_light">
                            <IconTruck className="i-va" /> Original Address
                        </div>
                        <div className="card-body">
                            <div className="row g-3">
                                <div className="col-md-12 input-group has-validation">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Attention"
                                        name="from_attention"
                                        value={this.state.from_attention}
                                        onChange={this.handleChange}
                                        required
                                    />
                                    <div className="invalid-feedback">
                                        Please choose a name.
                                    </div>
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Addresss"
                                        name="from_streetAdd"
                                        value={this.state.from_streetAdd}
                                        onChange={this.handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Address 2 (Optional)"
                                        name="from_streetAdd2"
                                        value={this.state.from_streetAdd2}
                                        onChange={this.handleChange}
                                    />
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="City"
                                        name="from_city"
                                        value={this.state.from_city}
                                        onChange={this.handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-4">
                                    <select className="form-select"
                                        name="from_countryCode"
                                        value={this.state.from_countryCode}
                                        onChange={this.handleCountryChange}
                                        required>
                                        <option value>-- Country --</option>
                                        <option value="US">United States</option>
                                        <option value="CA">Canada</option>
                                    </select>
                                </div>
                                <div className="col-md-4">
                                    <select className="form-select"
                                        name="from_state"
                                        value={this.state.from_state}
                                        onChange={this.handleChange} required>
                                        <option value>-- State --</option>
                                        {
                                            this.state.fromCountryStateList.map((item, index) =>
                                                <option key={item.value} value={item.value}>{item.name}</option>
                                            )
                                        }
                                    </select>
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Postal Code"
                                        name="from_postalCode"
                                        value={this.state.from_postalCode}
                                        onChange={this.handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-6">
                                    <input
                                        type="email"
                                        className="form-control"
                                        placeholder="Email Address"
                                        aria-label="Email Address"
                                        name="from_email"
                                        value={this.state.from_email}
                                        onChange={this.handleChange}
                                    />
                                </div>
                                <div className="col-md-6">
                                    <input
                                        type="tel"
                                        className="form-control"
                                        placeholder="Mobile no"
                                        aria-label="Mobile no"
                                        name="from_phone"
                                        value={this.state.from_phone}
                                        onChange={this.handleChange}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="card mb-3" style={{ borderColor: '#c13b2d' }}>
                        <div className="card-header brand_background_bold" style={{ color: '#fff' }}>
                            <IconTruck className="i-va" /> Destination Address
                        </div>
                        <div className="card-body">
                            <div className="row g-3">
                                <div className="col-md-12">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Attention"
                                        name="to_attention"
                                        value={this.state.to_attention}
                                        onChange={this.handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Addresss"
                                        name="to_streetAdd"
                                        value={this.state.to_streetAdd}
                                        onChange={this.handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Address 2 (Optional)"
                                        name="to_streetAdd2"
                                        value={this.state.to_streetAdd2}
                                        onChange={this.handleChange}
                                    />
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="City"
                                        name="to_city"
                                        value={this.state.to_city}
                                        onChange={this.handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-4">
                                    <select className="form-select"
                                        name="to_countryCode"
                                        value={this.state.to_countryCode}
                                        onChange={this.handleCountryChange} required>
                                        <option value>-- Country --</option>
                                        <option value={"CA"}>Canada</option>
                                        <option value={"US"}>United States</option>
                                    </select>
                                </div>
                                <div className="col-md-4">
                                    <select className="form-select"
                                        name="to_state"
                                        value={this.state.to_state}
                                        onChange={this.handleChange}
                                        required>
                                        <option value>-- State --</option>
                                        {
                                            this.state.toCountryStateList.map((item, index) =>
                                                <option key={item.value} value={item.value}>{item.name}</option>
                                            )
                                        }
                                    </select>
                                </div>
                                <div className="col-md-4">
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Zip"
                                        name="to_postalCode"
                                        value={this.state.to_postalCode}
                                        onChange={this.handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-6">
                                    <input
                                        type="email"
                                        className="form-control"
                                        placeholder="Email Address"
                                        aria-label="Email Address"
                                        name="to_email"
                                        value={this.state.to_email}
                                        onChange={this.handleChange}
                                    />
                                </div>
                                <div className="col-md-6">
                                    <input
                                        type="tel"
                                        className="form-control"
                                        placeholder="Mobile no"
                                        aria-label="Mobile no"
                                        name="to_phone"
                                        value={this.state.to_phone}
                                        onChange={this.handleChange}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        )
    }
}

export default Address