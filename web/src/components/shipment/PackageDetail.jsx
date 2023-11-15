
import React, { Component } from "react";
import { ReactComponent as IconPack } from "bootstrap-icons/icons/box-seam.svg";
class PackageDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            length:props.stateData.length || '',
            width:props.stateData.width || '',
            height:props.stateData.height || '',
            weight:props.stateData.weight || '',
            pkgValue:props.stateData.pkgValue || '',
            description:props.stateData.description || '',

            isValid: props.stateData.isValid
        };
    }

    handleChange = (event) => {
        this.setState({ [event.target.name]: event.target.value });
    }

    render() {
        return (
            <React.Fragment>
                <div className="col-md-12 order-2 order-lg-1">
                    <div className="card mb-3">
                        <div className="card-header brand_background_color_light">
                            <IconPack className="i-va" /> My Packaging
                        </div>
                        <div className="card-body" style={{ width: '100%', overflow: 'auto' }}>
                            <div className="row g-0 w-100 text-center fw-bold" style={{ backgroundColor: "#e9ecef", height: "50px", alignItems: "center" }}>
                                <div className="col-2">Length(Cm)</div>
                                <div className="col-2">Width(Cm)</div>
                                <div className="col-2">Height(Cm)</div>
                                <div className="col-2">Weigth(kg)</div>
                                <div className="col-2">Ins. Value($)</div>
                                <div className="col-2">Description</div>
                            </div>
                            <div className="row my-1 g-2 w-100 text-center" style={{ alignItems: "center" }}>
                                <div className="col-2">
                                    <input type="number"
                                        className="form-control"
                                        placeholder="L"
                                        name="length"
                                        value={this.state.length}
                                        onChange={this.handleChange} />
                                </div>
                                <div className="col-2">
                                    <input type="number"
                                        className="form-control"
                                        placeholder="W"
                                        name="width"
                                        value={this.state.width}
                                        onChange={this.handleChange} />
                                </div>
                                <div className="col-2">
                                    <input type="number"
                                        className="form-control"
                                        placeholder="H"
                                        name="height"
                                        value={this.state.height}
                                        onChange={this.handleChange} />
                                </div>
                                <div className="col-2">
                                    <input type="number"
                                        className="form-control"
                                        placeholder="Wt"
                                        name="weight"
                                        value={this.state.weight}
                                        onChange={this.handleChange} />
                                </div>
                                <div className="col-2">
                                    <input type="number"
                                        className="form-control"
                                        placeholder="Ins. Value"
                                        name="pkgValue"
                                        value={this.state.pkgValue}
                                        onChange={this.handleChange} />
                                </div>
                                <div className="col-2">
                                    <input type="text"
                                        className="form-control"
                                        placeholder="Description"
                                        name="description"
                                        value={this.state.description}
                                        onChange={this.handleChange} />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        )
    }
}

export default PackageDetail;