package net.sonic.gsls.contract;

import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.0.1.
 */
public final class SocialRecord extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b5b60008054600160a060020a03191633600160a060020a03161790555b5b61121a806100396000396000f300606060405236156100755763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b581146100775780636383cc201461008957806393a1122e146101a8578063c57411a814610212578063d3b493b314610331578063f1835db714610407575bfe5b341561007f57fe5b610087610442565b005b341561009157fe5b61011c600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375050604080516020601f89358b0180359182018390048302840183019094528083529799988101979196509182019450925082915084018382808284375094965061046f95505050505050565b604080518315158152602080820183815284519383019390935283519192916060840191850190808383821561016d575b80518252602083111561016d57601f19909201916020918201910161014d565b505050905090810190601f1680156101995780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b34156101b057fe5b6101fe600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375094965061089495505050505050565b604080519115158252519081900360200190f35b341561021a57fe5b61011c600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375050604080516020601f89358b0180359182018390048302840183019094528083529799988101979196509182019450925082915084018382808284375094965061094b95505050505050565b604080518315158152602080820183815284519383019390935283519192916060840191850190808383821561016d575b80518252602083111561016d57601f19909201916020918201910161014d565b505050905090810190601f1680156101995780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561033957fe5b610387600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843750949650610f1495505050505050565b6040805160208082528351818301528351919283929083019185019080838382156103cd575b8051825260208311156103cd57601f1990920191602091820191016103ad565b505050905090810190601f1680156103f95780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561040f57fe5b61042660043560ff60243516604435606435611083565b60408051600160a060020a039092168252519081900360200190f35b60005433600160a060020a0390811691161461045e5760006000fd5b600054600160a060020a0316ff5b5b565b60006104796110f4565b600160a060020a03331660009081526001602081905260409091200154849060ff1615801561050c57506002816040518082805190602001908083835b602083106104d55780518252601f1990920191602091820191016104b6565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff16159150505b1561088a576002856040518082805190602001908083835b602083106105435780518252601f199092019160209182019101610524565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff161591506105e69050576000606060405190810160405280602f81526020017f4974206973206e6f7420706f737369626c6520746f206372656174652074686981526020017f7320736f6369616c207265636f726400000000000000000000000000000000008152509250925061088a565b600160a060020a0333166000908152600160208190526040909120015460ff161561064a5760408051808201909152601881527f54686973207573657220616c7265616479206578697374730000000000000000602082015260009350915061088a565b604060405190810160405280858152602001600115158152506002866040518082805190602001908083835b602083106106955780518252601f199092019160209182019101610676565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381019093208451805191946106d694508593500190611106565b506020918201516001918201805460ff191691151591909117905560408051808201825288815280840183905233600160a060020a031660009081529284529120815180519293919261072c9284920190611106565b5060208201518160010160006101000a81548160ff0219169083151502179055509050507f28ba1e13b3c31eb411f244a6e1b269965b606b4befb99d94517174a24957c52b3386866040518084600160a060020a0316600160a060020a0316815260200180602001806020018381038352858181518152602001915080519060200190808383600083146107db575b8051825260208311156107db57601f1990920191602091820191016107bb565b505050905090810190601f1680156108075780820380516001836020036101000a031916815260200191505b5083810382528451815284516020918201918601908083838215610846575b80518252602083111561084657601f199092019160209182019101610826565b505050905090810190601f1680156108725780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a1600184925092505b5b5b509250929050565b60006002826040518082805190602001908083835b602083106108c85780518252601f1990920191602091820191016108a9565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092209150600090506109038282611185565b506001908101805460ff19169055600160a060020a033316600090815260209190915260408120906109358282611185565b506001908101805460ff1916905590505b919050565b60006109556110f4565b836002816040518082805190602001908083835b602083106109885780518252601f199092019160209182019101610969565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff169150508015610abb5750806040518082805190602001908083835b602083106109f45780518252601f1990920191602091820191016109d5565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019166001600033600160a060020a0316600160a060020a031681526020019081526020016000206000016040518082805460018160011615610100020316600290048015610aa85780601f10610a86576101008083540402835291820191610aa8565b820191906000526020600020905b815481529060010190602001808311610a94575b5050915050604051809103902060001916145b1561088a57846040518082805190602001908083835b60208310610af05780518252601f199092019160209182019101610ad1565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019166001600033600160a060020a0316600160a060020a031681526020019081526020016000206000016040518082805460018160011615610100020316600290048015610ba45780601f10610b82576101008083540402835291820191610ba4565b820191906000526020600020905b815481529060010190602001808311610b90575b5050915050604051809103902060001916141515610c4a576000608060405190810160405280606081526020017f54686973206163636f756e74206973206e6f7420616c6c6f77656420746f206d81526020017f6f646966792074686520736f6369616c207265636f726420636f72726573706f81526020017f6e64696e6720746f207468652073706563696669656420676c6f62616c2069648152509250925061088a565b6002856040518082805190602001908083835b60208310610c7c5780518252601f199092019160209182019101610c5d565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff1615159150610d209050576000606060405190810160405280602981526020017f5468652073706563696669656420736f6369616c207265636f726420646f657381526020017f6e277420657869737400000000000000000000000000000000000000000000008152509250925061088a565b604060405190810160405280858152602001600115158152506002866040518082805190602001908083835b60208310610d6b5780518252601f199092019160209182019101610d4c565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845180519194610dac94508593500190611106565b5060208201518160010160006101000a81548160ff0219169083151502179055509050507fcccdb45f3b5672bf7d1d195ebd44389811a7e68c2a0aa29a9d25cbd1eb2853d73386866040518084600160a060020a0316600160a060020a0316815260200180602001806020018381038352858181518152602001915080519060200190808383600083146107db575b8051825260208311156107db57601f1990920191602091820191016107bb565b505050905090810190601f1680156108075780820380516001836020036101000a031916815260200191505b5083810382528451815284516020918201918601908083838215610846575b80518252602083111561084657601f199092019160209182019101610826565b505050905090810190601f1680156108725780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a1600184925092505b5b5b509250929050565b610f1c6110f4565b6002826040518082805190602001908083835b60208310610f4e5780518252601f199092019160209182019101610f2f565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff1615159150610f9090505760006000fd5b6002826040518082805190602001908083835b60208310610fc25780518252601f199092019160209182019101610fa3565b518151600019602094850361010090810a820192831692199390931691909117909252949092019687526040805197889003820188208054601f60026001831615909802909501169590950492830182900482028801820190528187529294509250508301828280156110765780601f1061104b57610100808354040283529160200191611076565b820191906000526020600020905b81548152906001019060200180831161105957829003601f168201915b505050505090505b919050565b60408051600081815260208083018452918301819052825187815260ff87168184015280840186905260608101859052925190926001926080808301939192601f198301929081900390910190868661646e5a03f115156110e057fe5b50506020604051035190505b949350505050565b60408051602081019091526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061114757805160ff1916838001178555611174565b82800160010185558215611174579182015b82811115611174578251825591602001919060010190611159565b5b506111819291506111cd565b5090565b50805460018160011615610100020316600290046000825580601f106111ab57506111c9565b601f0160209004906000526020600020908101906111c991906111cd565b5b50565b6111eb91905b8082111561118157600081556001016111d3565b5090565b905600a165627a7a72305820ff4c0664925df40e1ed9d5c00428880bfe693ecd2269192902952c497aeaf9160029";

    private SocialRecord(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SocialRecord(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<SocialRecordAddedEventResponse> getSocialRecordAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SocialRecordAdded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<SocialRecordAddedEventResponse> responses = new ArrayList<SocialRecordAddedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            SocialRecordAddedEventResponse typedResponse = new SocialRecordAddedEventResponse();
            typedResponse.user = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
            typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SocialRecordAddedEventResponse> socialRecordAddedEventObservable() {
        final Event event = new Event("SocialRecordAdded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SocialRecordAddedEventResponse>() {
            @Override
            public SocialRecordAddedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SocialRecordAddedEventResponse typedResponse = new SocialRecordAddedEventResponse();
                typedResponse.user = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
                typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<SocialRecordUpdatedEventResponse> getSocialRecordUpdatedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SocialRecordUpdated", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<SocialRecordUpdatedEventResponse> responses = new ArrayList<SocialRecordUpdatedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            SocialRecordUpdatedEventResponse typedResponse = new SocialRecordUpdatedEventResponse();
            typedResponse.updater = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
            typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SocialRecordUpdatedEventResponse> socialRecordUpdatedEventObservable() {
        final Event event = new Event("SocialRecordUpdated", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SocialRecordUpdatedEventResponse>() {
            @Override
            public SocialRecordUpdatedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SocialRecordUpdatedEventResponse typedResponse = new SocialRecordUpdatedEventResponse();
                typedResponse.updater = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
                typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<SocialReocordDeletedEventResponse> getSocialReocordDeletedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SocialReocordDeleted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<SocialReocordDeletedEventResponse> responses = new ArrayList<SocialReocordDeletedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            SocialReocordDeletedEventResponse typedResponse = new SocialReocordDeletedEventResponse();
            typedResponse.deleter = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SocialReocordDeletedEventResponse> socialReocordDeletedEventObservable() {
        final Event event = new Event("SocialReocordDeleted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SocialReocordDeletedEventResponse>() {
            @Override
            public SocialReocordDeletedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SocialReocordDeletedEventResponse typedResponse = new SocialReocordDeletedEventResponse();
                typedResponse.deleter = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> addSocialRecord(Utf8String _globalId, Utf8String _socialRecordString) {
        Function function = new Function("addSocialRecord", Arrays.<Type>asList(_globalId, _socialRecordString), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> deleteSocialRecord(Utf8String _globalId) {
        Function function = new Function("deleteSocialRecord", Arrays.<Type>asList(_globalId), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> updateSocialRecord(Utf8String _globalId, Utf8String _socialRecordString) {
        Function function = new Function("updateSocialRecord", Arrays.<Type>asList(_globalId, _socialRecordString), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Utf8String> getSocialRecord(Utf8String _globalId) {
        Function function = new Function("getSocialRecord", 
                Arrays.<Type>asList(_globalId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Address> verify(Bytes32 _hash, Uint8 _v, Bytes32 _r, Bytes32 _s) {
        Function function = new Function("verify", 
                Arrays.<Type>asList(_hash, _v, _r, _s), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<SocialRecord> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(SocialRecord.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static Future<SocialRecord> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(SocialRecord.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static SocialRecord load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SocialRecord(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SocialRecord load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SocialRecord(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class SocialRecordAddedEventResponse {
        public Address user;

        public Utf8String globalId;

        public Utf8String socialRecordString;
    }

    public static class SocialRecordUpdatedEventResponse {
        public Address updater;

        public Utf8String globalId;

        public Utf8String socialRecordString;
    }

    public static class SocialReocordDeletedEventResponse {
        public Address deleter;

        public Utf8String globalId;
    }
}
