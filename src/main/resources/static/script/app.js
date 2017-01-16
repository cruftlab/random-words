
function getWord(url) {
    axios.get(url)
        .then(function (response) {
            console.log("ok");
            console.log(response);
            console.log("Word: " + response.data.combinedForm);
            word = response.data.combinedForm;
        })
        .catch(function (error) {
            console.log("error");
            console.log(error);
        });
     return word;
};

var Word = React.createClass({
    loadRandomWord: function(url) {
        axios
            .get(url)
            .then(function (response) {
                this.setState({
                    word: response.data.combinedForm
                });
            })
    },

    getInitialState: function() {
        return {word: ""};
    },

    componentDidMount: function() {
        var _this = this;
        axios
            .get(_this.props.url)
            .then(function (response) {
                _this.setState({
                    word: response.data.combinedForm
                });
            })
    },

    render: function() {
        return (
            <h1>{this.state.word}</h1>
        );
    }
});

var Links = React.createClass({
    render: function() {
        return (
            <a href="/" title="Nytt ord">Nytt ord</a>
        );
    }
});

ReactDOM.render(<Word url="/api/words/random/2" />, document.getElementById('randomWord'));
ReactDOM.render(<Links />, document.getElementById('links'));
