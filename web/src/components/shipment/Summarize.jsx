import React, { Component } from "react";
import { DownloadOutlined } from '@ant-design/icons';
import { Button, notification } from 'antd';
import { ReactComponent as IconExclamation } from "bootstrap-icons/icons/exclamation-circle.svg";
import { URL } from "../../url/UrlConstant"
class Summarize extends Component {

    constructor(props) {
        super(props);
        this.state = {
            loading: false,
            shipId: props.stateData.shipId || '',
            trackingNumbers: props.stateData.trackingNumbers || '',
            printUrl: props.stateData.printUrl || '',
        }
    }

    getRateService = async () => {
        this.setState({ loading: true })
        try {
            const postData = this.buildRequestDTO();
            const response = await fetch(URL.CREATE_LABEL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(postData),
            });

            if (!response.ok) {
                const errorMessage = await response.json();
                this.openNotification(errorMessage.messages);
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const blob = await response.blob();
            const downloadUrl = window.URL.createObjectURL(blob);
            const link = document.createElement('a');
            link.href = downloadUrl;
            link.setAttribute('download', 'shipping_label.pdf');
            document.body.appendChild(link);
            link.click();
            link.parentNode.removeChild(link);

        } catch (error) {
            console.log(error.message);
        } finally {
            this.setState({ loading: false });
        }
    }

    openNotification = (errorMessages) => {

        notification.open({
            message: <span style={{ color: "red" }}>Error</span>,
            description:
                <ul>
                    {
                        errorMessages.map((message) =>
                            <React.Fragment>
                                <li className="pb-1"><IconExclamation className="i-va pe-1" style={{ color: "red" }} />{message}</li>
                            </React.Fragment>
                        )
                    }
                </ul>,
            placement: 'bottom',
            duration: null
        });
    };

    buildRequestDTO = () => {
        return {
            labelUrl: this.state.printUrl.replace('http', 'https')
        }
    }
    render() {
        return (
            <React.Fragment>
                <div className="col-md-12 card mb-3">
                    <div className="card-body text-center">
                        <h3>Success: You have a Shipment Inprogress</h3>
                        <p>Your tracking Id: {this.state.trackingNumbers}</p>
                        <p>Ship Id: {this.state.shipId}</p>
                        <Button type="primary" icon={<DownloadOutlined />} 
                            size="large" onClick={this.getRateService} loading={this.state.loading}>
                            Download PDF Label
                        </Button>
                    </div>
                </div>
            </React.Fragment>
        )
    }
}

export default Summarize;