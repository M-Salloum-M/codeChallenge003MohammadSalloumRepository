import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class CustomerList extends Component {

  constructor(props) {
    super(props);
    this.state = {customers: [], isLoading: true};
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('customer/getAll')
      .then(response => response.json())
      .then(data => this.setState({customers: data, isLoading: false}));
  }

  async remove(id) {
    await fetch(`/customer/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedCustomers = [...this.state.customers].filter(i => i.id !== id);
      this.setState({customers: updatedCustomers});
    });
  }

  render() {
    const {customers, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const customerList = customers.map(customer => {
      return <tr key={customer.id}>
        <td style={{whiteSpace: 'nowrap'}}>{customer.name}</td>
        <td>{customer.address}</td>
        <td>{customer.mobileNumber}</td>
        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/customers/" + customer.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => this.remove(customer.id)}>Delete</Button>
          </ButtonGroup>
        </td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/customers/new">Add Customer</Button>
          </div>
          <h3>Customer List</h3>
          <Table className="mt-4">
            <thead>
              <tr>
                <th width="20%">Name</th>
                <th>Address</th>
                <th>MobileNumber</th>
                <th width="10%">Actions</th>
              </tr>
            </thead>
            <tbody>
            {customerList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default CustomerList;