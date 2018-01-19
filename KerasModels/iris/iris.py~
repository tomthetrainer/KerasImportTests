import numpy
import pandas
from keras.models import Sequential
from keras.layers import Dense
from keras.wrappers.scikit_learn import KerasClassifier
from keras.utils import np_utils
from sklearn.cross_validation import cross_val_score, KFold
from sklearn.preprocessing import LabelEncoder
from sklearn.pipeline import Pipeline
from keras import backend as K

# fix random seed for reproducibility
seed = 7
numpy.random.seed(seed)

# load dataset
dataframe = pandas.read_csv("iris.csv", header=None)
dataset = dataframe.values
X = dataset[:,0:4].astype(float)
Y = dataset[:,4]
print(X)
print(Y)

#encode class values as integers
encoder = LabelEncoder()
encoder.fit(Y)
encoded_Y = encoder.transform(Y)


# convert integers to dummy variables (hot encoded)
dummy_y = np_utils.to_categorical(encoded_Y)
print(dummy_y)

# define baseline model
#def baseline_model():
# create model
model = Sequential()
model.add(Dense(4, input_dim=4, activation='relu', name='layer1'))
model.add(Dense(3,activation='sigmoid', name='layer2'))

# Compile model
model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
    
#    return model
#model.fit
model.fit(X, dummy_y, nb_epoch=20, batch_size=5)
prediction = model.predict(numpy.array([[4.6,3.6,1.0,0.2]]));
print(prediction);


#print('********')
# print(backend())
#print(tf.keras.backend)
#print(str(_BACKEND))
#print(K.backend() + '.h5')
#print('******')

# To casve just the weights
#model.save_weights('/tmp/iris_model_weights')

# To save the weights and the config
# Note this is what is used for this demo
savename = 'iris_' + K.backend() + '.h5'
model.save(savename)

# To save the Json config to a file
#json_string = model.to_json()
#text_file = open("/tmp/iris_model_json", "w")
#text_file.write(json_string)
#text_file.close()
